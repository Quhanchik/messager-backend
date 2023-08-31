package kz.fakewhatsapp.fakewhatsapp.dto;

import kz.fakewhatsapp.fakewhatsapp.models.User;

public class ResponseRegisterUser {
    private User user;
    private String jwt;

    public ResponseRegisterUser(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
