package kz.fakewhatsapp.fakewhatsapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "friend_request")
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private User senderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accepter_id")
    private User accepterId;

    public FriendRequest() {
    }

    public FriendRequest(User senderId, User accepterId) {
        this.senderId = senderId;
        this.accepterId = accepterId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public User getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(User accepterId) {
        this.accepterId = accepterId;
    }
}
