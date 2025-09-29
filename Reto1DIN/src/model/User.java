package model;

import java.io.Serializable;


/**
 *
 * @author Usuario
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String birthDate;
    private String desc;
    private Gender gender;

    /**
     * Empty constructor
     */
    public User() {
        this.username = "";
        this.password = "";
        this.birthDate = "";
        this.desc = "";
        this.gender = Gender.OTHER;
    }

    /**
     * constructor for the user
     * 
     * @param username
     * @param password
     * @param birthDate
     * @param desc
     * @param gender
     */
    public User(String username, String password, String birthDate, String desc, Gender gender) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.desc = desc;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", birthDate=" + birthDate + ", desc=" + desc + ", gender=" + gender + '}';
    }
}
