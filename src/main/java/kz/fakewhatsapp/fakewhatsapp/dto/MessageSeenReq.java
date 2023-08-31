package kz.fakewhatsapp.fakewhatsapp.dto;

public class MessageSeenReq {
    private long message;
    private int user;

    public MessageSeenReq() {}

    public MessageSeenReq(long message, int user) {
        this.message = message;
        this.user = user;
    }

    public long getMessage() {
        return message;
    }

    public void setMessage(long message) {
        this.message = message;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MessageSeenReq{" +
                "message=" + message +
                ", user=" + user +
                '}';
    }
}
