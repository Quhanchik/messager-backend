package kz.fakewhatsapp.fakewhatsapp.repositories;

import kz.fakewhatsapp.fakewhatsapp.models.Friends;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Integer> {
    public Friends findByFriendId(int id);
    public Friends findByUserId(int id);
    public List<Friends> findFriendsByUserId(User user);
}
