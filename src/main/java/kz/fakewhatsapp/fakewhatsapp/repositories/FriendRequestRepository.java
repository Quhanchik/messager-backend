package kz.fakewhatsapp.fakewhatsapp.repositories;

import kz.fakewhatsapp.fakewhatsapp.models.FriendRequest;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    public void deleteByAccepterIdAndSenderId(User accepterId, User senderId);
}
