package kz.fakewhatsapp.fakewhatsapp.controller;

import kz.fakewhatsapp.fakewhatsapp.dto.FriendRequestReq;
import kz.fakewhatsapp.fakewhatsapp.dto.RequestUser;
import kz.fakewhatsapp.fakewhatsapp.dto.ResponseUsers;
import kz.fakewhatsapp.fakewhatsapp.dto.UserDTO;
import kz.fakewhatsapp.fakewhatsapp.models.FriendRequest;
import kz.fakewhatsapp.fakewhatsapp.models.Friends;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.services.FriendRequestService;
import kz.fakewhatsapp.fakewhatsapp.services.FriendsService;
import kz.fakewhatsapp.fakewhatsapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private ModelMapper modelMapper;
    private SimpMessagingTemplate messagingTemplate;
    private FriendsService friendsService;
    private final FriendRequestService friendRequestService;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, SimpMessagingTemplate messagingTemplate, FriendsService friendsService, FriendRequestService friendRequestService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.messagingTemplate = messagingTemplate;
        this.friendsService = friendsService;
        this.friendRequestService = friendRequestService;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") int id) {
        User user = userService.findUserById(id);

        System.out.println(user);

        return convertUserToUserDTO(user);
    }

    @MessageMapping("/friendRequest")
    public void addFriendRequest(@RequestBody FriendRequestReq req) {
        FriendRequest friendRequest = new FriendRequest(
                userService.findUserById(req.getSenderId()),
                userService.findUserById(req.getAccepterId())
        );

        friendRequestService.save(friendRequest);

        System.out.println("/" + req.getSenderId() + "/friendResponse");

        messagingTemplate.convertAndSend("/" + req.getAccepterId() + "/friendResponse", friendRequest);
        messagingTemplate.convertAndSend("/" + req.getSenderId() + "/friendRequest", friendRequest);
    }

    @MessageMapping("/acceptFriend")
    public void acceptFriend(@RequestBody FriendRequestReq req) {
        Friends friends = new Friends(
            userService.findUserById(req.getAccepterId()),
            userService.findUserById(req.getSenderId())
        );

        friendsService.save(friends);

        friendRequestService.deleteByAccepterAndSender(
                userService.findUserById(req.getSenderId()),
                userService.findUserById(req.getAccepterId())
        );

        friendRequestService.deleteByAccepterAndSender(
                userService.findUserById(req.getAccepterId()),
                userService.findUserById(req.getSenderId())
        );

        messagingTemplate.convertAndSend("/" + req.getAccepterId() + "/acceptFriend", friends);
        messagingTemplate.convertAndSend("/" + req.getSenderId() + "/acceptFriend", friends);
    }

    @MessageMapping("/declainFriend")
    public void declainFriend(@RequestBody FriendRequestReq req) {
        friendRequestService.deleteByAccepterAndSender(
                userService.findUserById(req.getSenderId()),
                userService.findUserById(req.getAccepterId())
        );

        friendRequestService.deleteByAccepterAndSender(
                userService.findUserById(req.getAccepterId()),
                userService.findUserById(req.getSenderId())
        );

        messagingTemplate.convertAndSend("/" + req.getAccepterId() + "/declainFriend", "msg");
        messagingTemplate.convertAndSend("/" + req.getSenderId() + "/declainFriend", "msg");
    }

//    @PostMapping("/sendFriendRequest")
//    public ResponseEntity<?> addFriendRequest(@RequestBody SendFriendRequest sendFriendRequest) {
//        int firstId = sendFriendRequest.getFirstUser();
//        int secondId = sendFriendRequest.getSecondUser();
//        userService.addFriendRequest(firstId, secondId);
//
//        return ResponseEntity.ok("Sent");
//    }

    @GetMapping("/test")
    public UserDTO test() {
        return convertUserToUserDTO(userService.findUserByLogin("test1").get());
    }

    @PostMapping("/findPeople")
    public ResponseEntity<ResponseUsers> findPeople(@RequestBody RequestUser user) {
        List<User> userFromDB = userService.findUsersByLoginStartingWith(user.getLogin());

        List<UserDTO> userDTO = new ArrayList<>();

        for(User temp : userFromDB) {
            userDTO.add(convertUserToUserDTO(temp));
        }

        return ResponseEntity.ok(new ResponseUsers(userDTO));
    }

    private UserDTO convertUserToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

//    @GetMapping("/friends/{id}")
//    public List<Friends> test2(@PathVariable("id") int id) {
//        return friendsService.getFriendsById(id);
//    }
}
