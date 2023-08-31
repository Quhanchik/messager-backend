package kz.fakewhatsapp.fakewhatsapp.dto;

import kz.fakewhatsapp.fakewhatsapp.models.Chat;

import java.util.Date;
import java.util.List;

public class MessageDTO {
    private Long id;

    private String text;

    private UserShortDTO sender;

    private Date sentTime;

    private Chat chat;

    private boolean isFile;

    private List<UserDTO> views;

    public MessageDTO(Long id, String text, UserShortDTO sender, Date sentTime, Chat chat, boolean isFile, List<UserDTO> views) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.sentTime = sentTime;
        this.chat = chat;
        this.isFile = isFile;
        this.views = views;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public MessageDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserShortDTO getSender() {
        return sender;
    }

    public void setSender(UserShortDTO sender) {
        this.sender = sender;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public List<UserDTO> getViews() {
        return views;
    }

    public void setViews(List<UserDTO> views) {
        this.views = views;
    }
}
