package kr.hs.dsm.java.taxipot_backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "taxipot")
public class TaxiPot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer room_id;
    float start_longtitude;
    float start_latitude;
    float end_longtitude;
    float end_latitude;
    long depart_time;
    boolean gender_man;
    boolean gender_woman;
    int start_age;
    int end_age = 100;
    String first_seat;
    String second_seat;
    String third_seat;
    String fourth_seat;

    public void setFirst_seat(String first_seat) {
        this.first_seat = first_seat;
    }

    public void setSecond_seat(String second_seat) {
        this.second_seat = second_seat;
    }

    public void setThird_seat(String third_seat) {
        this.third_seat = third_seat;
    }

    public void setFourth_seat(String fourth_seat) {
        this.fourth_seat = fourth_seat;
    }

    public TaxiPot() {
    }

    public TaxiPot(float start_longtitude, float start_latitude, float end_longtitude, float end_latitude, long depart_time, boolean gender_man, boolean gender_woman, int start_age, int end_age, String first_seat, String second_seat, String third_seat, String fourth_seat) {
        this.start_longtitude = start_longtitude;
        this.start_latitude = start_latitude;
        this.end_longtitude = end_longtitude;
        this.end_latitude = end_latitude;
        this.depart_time = depart_time;
        this.gender_man = gender_man;
        this.gender_woman = gender_woman;
        this.start_age = start_age;
        this.end_age = end_age;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.third_seat = third_seat;
        this.fourth_seat = fourth_seat;
    }
}
