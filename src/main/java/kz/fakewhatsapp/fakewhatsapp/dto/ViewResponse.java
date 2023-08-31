package kz.fakewhatsapp.fakewhatsapp.dto;

public class ViewResponse {
    private long messageId;
    private UserShortDTO userId;
    private long chatId;

    public ViewResponse(long messageId, UserShortDTO userId, long chatId) {
        this.messageId = messageId;
        this.userId = userId;
        this.chatId = chatId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public UserShortDTO getUserId() {
        return userId;
    }

    public void setUserId(UserShortDTO userId) {
        this.userId = userId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
