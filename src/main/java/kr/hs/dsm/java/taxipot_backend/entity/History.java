package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

    float start_longtitude;
    float start_latitude;
    float end_longtitude;
    float end_latitude;

    long depart_time;

    public History() {
    }

    public History(EmbeddedHistory userRoomId, String first_seat, String second_seat, String third_seat, String fourth_seat, float start_longtitude, float start_latitude, float end_longtitude, float end_latitude, long departTime) {
        this.userRoomId = userRoomId;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.third_seat = third_seat;
        this.fourth_seat = fourth_seat;
        this.start_longtitude = start_longtitude;
        this.start_latitude = start_latitude;
        this.end_longtitude = end_longtitude;
        this.end_latitude = end_latitude;
        this.depart_time = departTime;
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

    public float getStart_longtitude() {
        return start_longtitude;
    }

    public void setStart_longtitude(float start_longtitude) {
        this.start_longtitude = start_longtitude;
    }

    public float getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(float start_latitude) {
        this.start_latitude = start_latitude;
    }

    public float getEnd_longtitude() {
        return end_longtitude;
    }

    public void setEnd_longtitude(float end_longtitude) {
        this.end_longtitude = end_longtitude;
    }

    public float getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(float end_latitude) {
        this.end_latitude = end_latitude;
    }

    public long getDepartTime() {
        return depart_time;
    }

    public void setDepartTime(long departTime) {
        this.depart_time = departTime;
    }
}
