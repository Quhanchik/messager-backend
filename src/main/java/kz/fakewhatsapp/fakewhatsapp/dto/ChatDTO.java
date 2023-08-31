package kz.fakewhatsapp.fakewhatsapp.dto;

import kz.fakewhatsapp.fakewhatsapp.models.Message;
import kz.fakewhatsapp.fakewhatsapp.models.User;

import java.util.List;

public class ChatDTO {
    private int id;
    private String title;
    private String avatar;
    private List<User> members;

    public ChatDTO(int id, String title, String avatar, List<User> members) {
        this.id = id;
        this.title = title;
        this.avatar = avatar;
        this.members = members;
    }

    public ChatDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
