package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.dto.UserDTO;
import kz.fakewhatsapp.fakewhatsapp.models.User;
import kz.fakewhatsapp.fakewhatsapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findUsersByLoginStartingWith(String login) {
        return userRepository.findUsersByLoginStartingWith(login);
    }

    public User findUserById(int id) {
        return userRepository.findUsersById(id);
    }
}
