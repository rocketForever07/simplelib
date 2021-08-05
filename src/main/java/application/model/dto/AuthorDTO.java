package application.model.dto;

import javax.persistence.Column;
import java.util.Date;


public class AuthorDTO {

    private int id;

    private String fullName;

    private String nickName;

    private Date DoB;

    public AuthorDTO() {
    }

    public AuthorDTO(int id, String fullName, String nickName, Date doB) {
        this.id = id;
        this.fullName = fullName;
        this.nickName = nickName;
        DoB = doB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }
}
