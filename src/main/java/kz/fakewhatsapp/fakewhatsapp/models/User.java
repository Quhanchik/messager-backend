package kz.fakewhatsapp.fakewhatsapp.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Embeddable
@Table(name = "_user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", length = Integer.MAX_VALUE)
    @JsonIgnore
    private String password;

    @Column(name = "login", length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "fullname", length = Integer.MAX_VALUE)
    private String fullname;

    @Column(name = "descr", length = Integer.MAX_VALUE)
    private String descr;

    @Column(name = "authority", length = Integer.MAX_VALUE)
    private String authority;
    @Column(name = "avatar", length = Integer.MAX_VALUE)
    private String avatar;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Friends> friends;

    @OneToMany(mappedBy = "friendId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Friends> friends2;

    @JsonIgnore
    @OneToMany(mappedBy = "senderId", fetch = FetchType.EAGER)
    private List<FriendRequest> friendRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "accepterId", fetch = FetchType.EAGER)
    private List<FriendRequest> friendResponses;

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    @JsonIgnore
//    @JoinTable(name = "chat_user",
//            joinColumns = @JoinColumn(name = "chat_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Chat> chats;

    public User(String login, String password, String fullname, String descr, String authority, String avatar) {
        this.password = password;
        this.login = login;
        this.fullname = fullname;
        this.descr = descr;
        this.authority = authority;
        this.avatar = avatar;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<FriendRequest> getFriendRequests() {
        return friendRequests;
    }

    public void setFriendRequests(List<FriendRequest> friendRequests) {
        this.friendRequests = friendRequests;
    }

    public List<FriendRequest> getFriendResponses() {
        return friendResponses;
    }

    public void setFriendResponses(List<FriendRequest> friendResponses) {
        this.friendResponses = friendResponses;
    }

    public List<Friends> getFriends2() {
        return friends2;
    }

    public void setFriends2(List<Friends> friends2) {
        this.friends2 = friends2;
    }

    //    public List<User> getiSendFriendRequests() {
//        return iSendFriendRequests;
//    }
//
//    public void setiSendFriendRequests(List<User> iSendFriendRequests) {
//        this.iSendFriendRequests = iSendFriendRequests;
//    }

//    public List<User> getOtherSendFriendRequests() {
//        return otherSendFriendRequests;
//    }
//
//    public void setOtherSendFriendRequests(List<User> otherSendFriendRequests) {
//        this.otherSendFriendRequests = otherSendFriendRequests;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id && Objects.equals(password, user.password) && Objects.equals(login, user.login) && Objects.equals(fullname, user.fullname) && Objects.equals(descr, user.descr) && Objects.equals(authority, user.authority);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, password, login, fullname, descr, authority);
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", fullname='" + fullname + '\'' +
                ", descr='" + descr + '\'' +
                ", authority='" + authority + '\'' +
                ", avatar='" + avatar + '\'' +
                ", friends=" + friends +
                ", chats=" + chats +
                '}';
    }
}
