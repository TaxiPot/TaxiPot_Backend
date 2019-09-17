package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
    @EmbeddedId
    EmbeddedHistory userRoomId;
    String first_seat;
    String second_seat;
    String third_seat;
    String fourth_seat;

    public History() {
    }

    public History(EmbeddedHistory userRoomId, String first_seat, String second_seat, String third_seat, String fourth_seat) {
        this.userRoomId = userRoomId;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.third_seat = third_seat;
        this.fourth_seat = fourth_seat;
    }

    public EmbeddedHistory getUserRoomId() {
        return userRoomId;
    }

    public void setUserRoomId(EmbeddedHistory userRoomId) {
        this.userRoomId = userRoomId;
    }

    public String getFirst_seat() {
        return first_seat;
    }

    public void setFirst_seat(String first_seat) {
        this.first_seat = first_seat;
    }

    public String getSecond_seat() {
        return second_seat;
    }

    public void setSecond_seat(String second_seat) {
        this.second_seat = second_seat;
    }

    public String getThird_seat() {
        return third_seat;
    }

    public void setThird_seat(String third_seat) {
        this.third_seat = third_seat;
    }

    public String getFourth_seat() {
        return fourth_seat;
    }

    public void setFourth_seat(String fourth_seat) {
        this.fourth_seat = fourth_seat;
    }
}
