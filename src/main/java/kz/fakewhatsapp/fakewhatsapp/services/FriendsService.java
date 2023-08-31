package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.models.Friends;
import kz.fakewhatsapp.fakewhatsapp.repositories.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendsService {
    private final FriendsRepository friendsRepository;
    private final UserService userService;

    @Autowired
    public FriendsService(FriendsRepository friendsRepository, UserService userService) {
        this.friendsRepository = friendsRepository;
        this.userService = userService;
    }

    public void save(Friends friends) {
        friendsRepository.save(friends);
    }

//    public List<Friends> getFriendsById(int id) {
//        return friendsRepository.findFriendsByUserId(userService.findUserById(id));
//    }
}
