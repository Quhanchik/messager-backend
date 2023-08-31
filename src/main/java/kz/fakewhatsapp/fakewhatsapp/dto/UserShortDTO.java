package kz.fakewhatsapp.fakewhatsapp.dto;

public class UserShortDTO {
    private int id;
    private String login;
    private String descr;
    private String fullname;
    private String authority;
    private String avatar;

    public UserShortDTO(int id, String login, String descr, String fullname, String authority, String avatar) {
        this.id = id;
        this.login = login;
        this.descr = descr;
        this.fullname = fullname;
        this.authority = authority;
        this.avatar = avatar;
    }

    public UserShortDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
