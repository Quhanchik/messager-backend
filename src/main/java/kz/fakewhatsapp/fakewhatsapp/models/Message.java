package kz.fakewhatsapp.fakewhatsapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Embeddable
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;
    private Date sentTime;

    private boolean isFile;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToMany
    @JoinTable(name = "message_user",
    joinColumns = @JoinColumn(name = "message_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> views;

    public Message() {

    }

    public Message(String text, Date sentTime, User sender, Chat chat, boolean isFile) {
        this.text = text;
        this.sentTime = sentTime;
        this.sender = sender;
        this.chat = chat;
        this.isFile = isFile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public List<User> getViews() {
        return views;
    }

    public void setViews(List<User> views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sentTime=" + sentTime +
                ", sender=" + sender +
                ", chat=" + chat +
                '}';
    }
}
