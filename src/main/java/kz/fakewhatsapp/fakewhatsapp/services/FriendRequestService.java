package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.models.FriendRequest;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.repositories.FriendRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public void save(FriendRequest friendRequest) {
        friendRequestRepository.save(friendRequest);
    }

    public void deleteByAccepterAndSender(User accepterId, User senderId) {
        friendRequestRepository.deleteByAccepterIdAndSenderId(accepterId, senderId);
    }
}
