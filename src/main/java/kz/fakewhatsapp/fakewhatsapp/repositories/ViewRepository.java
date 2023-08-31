package kz.fakewhatsapp.fakewhatsapp.repositories;

import kz.fakewhatsapp.fakewhatsapp.models.Message;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.models.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends JpaRepository<Views, Long> {
    public List<Views> getViewsByMessageId(Message msg);

    public Views getViewsByMessageIdAndUserId(Message message, User user);
}
