package kz.fakewhatsapp.fakewhatsapp.dto;

import kz.fakewhatsapp.fakewhatsapp.models.User;

import java.util.List;

public class ResponseUsers {
    List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public ResponseUsers(List<UserDTO> users) {
        this.users = users;
    }
}
