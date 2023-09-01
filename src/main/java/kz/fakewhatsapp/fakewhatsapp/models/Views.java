package kz.fakewhatsapp.fakewhatsapp.models;

import jakarta.persistence.*;

@Entity
@Embeddable
@Table(name = "message_user")
public class Views {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "message_id")
    private Message messageId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    public Views(Message messageId, User userId) {
        this.messageId = messageId;
        this.userId = userId;
    }

    public Views() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Message getMessageId() {
        return messageId;
    }

    public void setMessageId(Message messageId) {
        this.messageId = messageId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Views{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", userId=" + userId +
                '}';
    }
}
