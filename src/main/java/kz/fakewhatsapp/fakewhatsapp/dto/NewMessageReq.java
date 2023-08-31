package kz.fakewhatsapp.fakewhatsapp.dto;

public class NewMessageReq {
    private String text;
    private int sender;
    private Long chatId;
    private boolean isFile;
    private int activeChat;


    public int getActiveChat() {
        return activeChat;
    }

    public void setActiveChat(int activeChat) {
        this.activeChat = activeChat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }
}
