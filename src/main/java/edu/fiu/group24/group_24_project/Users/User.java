package edu.fiu.group24.group_24_project.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class User {
    @Id
    @Column(name = "username")
    String userUsername;
    @Column(name = "password", nullable = false)
    String userPassword;
    @Column(name = "first_name")
    String userFirstName;
    @Column(name = "last_name")
    String userLastName;
    @Column(name = "email")
    String userEmail;

    @Column(length = 1000, name = "home_address")
    String userHomeAddress;

    public User() {
    }

    public User(String userUsername, String userPassword, String userFirstName,
                String userLastName, String userEmail, String userHomeAddress) {
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userHomeAddress = userHomeAddress;
    }

    //region Getters
    public String getUserUsername() { return userUsername; }
    public String getUserPassword() { return userPassword; }
    public String getUserFirstName() { return userFirstName; }
    public String getUserLastName() { return userLastName; }
    public String getUserEmail() { return userEmail; }
    public String getUserHomeAddress() { return userHomeAddress; }
    //endregion

    //region Setters
    public void setUserUsername(String userUsername) { this.userUsername = userUsername; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setUserFirstName(String userFirstName) { this.userFirstName = userFirstName; }
    public void setUserLastName(String userLastName) { this.userLastName = userLastName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserHomeAddress(String userHomeAddress) { this.userHomeAddress = userHomeAddress; }
    //endregion

    @Override
    public String toString() {
        return "User{"
                + "username='" + userUsername + '\'' +
                ", firstName='" + userFirstName + '\'' +
                ", email='" + userEmail + '\'' +
                '}';
    }
}
