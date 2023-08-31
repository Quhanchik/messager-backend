package kz.fakewhatsapp.fakewhatsapp.dto;

public class MessageReq {
    private Long chatId;
    private int page;

    public MessageReq(Long chatId, int page) {
        this.chatId = chatId;
        this.page = page;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
