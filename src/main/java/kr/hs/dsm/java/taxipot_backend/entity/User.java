package kr.hs.dsm.java.taxipot_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User {

    @Id
    String user_id;
    String user_password;
    int age;
    int gender;
    int trust_point;

    public User() {}

    public User(String user_id, String user_password, int age, int gender, int trust_point) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.age = age;
        this.gender = gender;
        this.trust_point = trust_point;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTrust_point() {
        return trust_point;
    }

    public void setTrust_point(int trust_point) {
        this.trust_point = trust_point;
    }
}
