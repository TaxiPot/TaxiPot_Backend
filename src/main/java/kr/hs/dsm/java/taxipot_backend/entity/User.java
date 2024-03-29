package kr.hs.dsm.java.taxipot_backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="user")
public class User {

    @Id
    String user_id;
    String user_password;
    int age;
    boolean gender;
    int trust_point;
    @Column(name = "room_id")
    Integer roomId;
    @Column(name = "seat_num")
    Integer seatNum;

    public User() {}

    public User(String user_id, String user_password, int age, boolean gender, int trust_point, Integer roomId, Integer seatNum) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.age = age;
        this.gender = gender;
        this.trust_point = trust_point;
        this.roomId = roomId;
        this.seatNum = seatNum;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", trust_point=" + trust_point +
                ", roomId=" + roomId +
                ", seatNum=" + seatNum +
                '}';
    }
}
