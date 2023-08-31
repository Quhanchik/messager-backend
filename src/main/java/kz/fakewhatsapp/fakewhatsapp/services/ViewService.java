package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.models.Message;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.models.Views;
import kz.fakewhatsapp.fakewhatsapp.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewService {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public List<Views> getViewsByMessageId(Message msg) {
        return viewRepository.getViewsByMessageId(msg);
    }

    public void save(Views views) {
        viewRepository.save(views);
    }

    public Views getViewsByMessageAndUser(Message message, User user) {
        return viewRepository.getViewsByMessageIdAndUserId(message, user);
    }
}
