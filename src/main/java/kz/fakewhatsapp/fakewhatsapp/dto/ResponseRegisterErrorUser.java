package kz.fakewhatsapp.fakewhatsapp.dto;

public class ResponseRegisterErrorUser {
    private String errorMessage;

    public ResponseRegisterErrorUser(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
