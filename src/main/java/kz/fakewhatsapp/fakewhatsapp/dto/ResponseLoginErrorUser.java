package kz.fakewhatsapp.fakewhatsapp.dto;

public class ResponseLoginErrorUser {
    private String errorMessage;

    public ResponseLoginErrorUser(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
