package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "taxipot")
public class TaxiPot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int room_id;
    float start_longtitude;
    float start_latitude;
    float end_longtitude;
    float end_latitude;
    long depart_time;
    int gender;
    int start_age;
    int end_age;
    String first_seat;
    String second_seat;
    String third_seat;
    String fourth_seat;

    public TaxiPot() {
    }

    public TaxiPot(float start_longtitude, float start_latitude, float end_longtitude, float end_latitude, long depart_time, int gender, int start_age, int end_age, String first_seat, String second_seat, String third_seat, String fourth_seat) {
        this.start_longtitude = start_longtitude;
        this.start_latitude = start_latitude;
        this.end_longtitude = end_longtitude;
        this.end_latitude = end_latitude;
        this.depart_time = depart_time;
        this.gender = gender;
        this.start_age = start_age;
        this.end_age = end_age;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.third_seat = third_seat;
        this.fourth_seat = fourth_seat;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
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

    public long getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(long depart_time) {
        this.depart_time = depart_time;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStart_age() {
        return start_age;
    }

    public void setStart_age(int start_age) {
        this.start_age = start_age;
    }

    public int getEnd_age() {
        return end_age;
    }

    public void setEnd_age(int end_age) {
        this.end_age = end_age;
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
