package kz.fakewhatsapp.fakewhatsapp.dto;

public class FriendRequestReq {
    private int senderId;
    private int accepterId;

    public FriendRequestReq(int senderId, int accepterId) {
        this.senderId = senderId;
        this.accepterId = accepterId;
    }

    public FriendRequestReq() {

    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(int accepterId) {
        this.accepterId = accepterId;
    }
}
