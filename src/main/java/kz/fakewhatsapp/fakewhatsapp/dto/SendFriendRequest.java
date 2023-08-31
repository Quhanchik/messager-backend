package kz.fakewhatsapp.fakewhatsapp.dto;

public class SendFriendRequest {
    private int firstUser;
    private int secondUser;

    public SendFriendRequest(int firstUser, int secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

    public SendFriendRequest() {

    }

    public int getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(int firstUser) {
        this.firstUser = firstUser;
    }

    public int getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(int secondUser) {
        this.secondUser = secondUser;
    }
}
