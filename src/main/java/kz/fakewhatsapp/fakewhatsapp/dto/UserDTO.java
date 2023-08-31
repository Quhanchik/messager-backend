package kz.fakewhatsapp.fakewhatsapp.dto;

import kz.fakewhatsapp.fakewhatsapp.models.FriendRequest;
import kz.fakewhatsapp.fakewhatsapp.models.Friends;

import java.util.List;

public class UserDTO {
    private int id;
    private String login;
    private String descr;
    private String fullname;
    private String authority;
    private String avatar;
    private List<Friends> friends;
    private List<Friends> friends2;

    private List<FriendRequest> friendRequests;

    private List<FriendRequest> friendResponses;
    private List<ChatDTO> chats;

    public UserDTO(int id, String login, String descr, String fullname, String authority, List<Friends> friends2, List<FriendRequest> friendRequests, List<FriendRequest> friendResponses) {
        this.id = id;
        this.login = login;
        this.descr = descr;
        this.fullname = fullname;
        this.authority = authority;
        this.friends2 = friends2;
        this.friendRequests = friendRequests;
        this.friendResponses = friendResponses;
    }

    public UserDTO() {
    }

    public List<ChatDTO> getChats() {
        return chats;
    }

    public void setChats(List<ChatDTO> chats) {
        this.chats = chats;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
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
}
