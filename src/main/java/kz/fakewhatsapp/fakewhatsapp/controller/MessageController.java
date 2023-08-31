package kz.fakewhatsapp.fakewhatsapp.controller;

import kz.fakewhatsapp.fakewhatsapp.dto.*;
import kz.fakewhatsapp.fakewhatsapp.models.Message;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.models.Views;
import kz.fakewhatsapp.fakewhatsapp.services.ChatService;
import kz.fakewhatsapp.fakewhatsapp.services.MessageService;
import kz.fakewhatsapp.fakewhatsapp.services.UserService;
import kz.fakewhatsapp.fakewhatsapp.services.ViewService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;
    private SimpMessagingTemplate messagingTemplate;
    private UserService userService;
    private final ChatService chatService;
    private final ViewService viewService;

    private final ModelMapper modelMapper;


    public MessageController(MessageService messageService, SimpMessagingTemplate messagingTemplate, UserService userService, ChatService chatService, ViewService viewService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
        this.userService = userService;
        this.chatService = chatService;
        this.viewService = viewService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/pagination")
    public Page<Message> paginatedMessages(@RequestBody MessageReq req) {
        Pageable pageable = PageRequest.of(req.getPage(), 50);

        return messageService.findAllByChat(chatService.getChatById(req.getChatId()), pageable);
    }

    @MessageMapping("/view")
    public void processView(@RequestBody MessageSeenReq req) {
        boolean isViewExists = viewService.getViewsByMessageAndUser(
                messageService.findById(req.getMessage()),
                userService.findUserById(req.getUser())
        ) != null;

        if(isViewExists) {
            return;
        }

        System.out.println(req);
        Views views = new Views(
                messageService.findById(req.getMessage()),
                userService.findUserById(req.getUser())
        );
        System.out.println(views);
        viewService.save(views);

        messagingTemplate.convertAndSend("/" + messageService.findById(req.getMessage()).getChat().getId() + "/view", new ViewResponse(
                req.getMessage(),
                convertUserToUserShortDTO(userService.findUserById(req.getUser())),
                messageService.findById(req.getMessage()).getChat().getId()
        ));
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        messageService.delete(id);
    }

    @GetMapping("/getViewsSubs/{id}")
    public List<String> getViewsSubs(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        List<String> subs = user.getChats().stream().map(elem -> {
            return "/" + elem.getId() + "/view";
        }).toList();

        System.out.println(subs);

        return subs;
    }

    @GetMapping("/getMessagesSubs/{id}")
    public List<String> getMessagesSubs(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        List<String> subs = user.getChats().stream().map(elem -> {
            return "/" + elem.getId() + "/messages";
        }).toList();

        System.out.println(subs);

        return subs;
    }


    @MessageMapping("/message")
    public void processMessage(@Payload NewMessageReq message) {
        Message newMessage = new Message(message.getText(),
                new Date(),
                userService.findUserById(message.getSender()),
                chatService.getChatById(message.getChatId()),
                message.isFile());

        messageService.save(newMessage);

        System.out.println(newMessage);

        messagingTemplate.convertAndSend("/" + message.getChatId().toString() + "/messages", convertMessageToMessageDTO(newMessage));
    }

    @PostMapping(value = "/test", consumes = {"multipart/form-data"})
    public ResponseEntity<?> test(@RequestParam MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), Path.of("C:\\Users\\user\\Desktop\\backend\\fakewhatsapp\\src\\main\\java\\kz\\fakewhatsapp\\fakewhatsapp\\files").resolve(file.getOriginalFilename()));
        } catch (Exception e) {
        }
        System.out.println(file);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body(file);
    }

    private MessageDTO convertMessageToMessageDTO(Message message) {
        return modelMapper.map(message, MessageDTO.class);
    }
    private UserShortDTO convertUserToUserShortDTO(User user) {
        return modelMapper.map(user, UserShortDTO.class);
    }
}
