package application.model.dto;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

public class UserDTO {

    private int id;

    private String userName;

    private String email;

    private String avatar;

    private int gender;

    private String address;

    private String name;

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
