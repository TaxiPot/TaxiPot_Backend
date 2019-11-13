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
    @Column(name = "depart_time")
    long departTime;
    boolean gender_man;
    boolean gender_woman;
    @Column(name = "start_age")
    int startAge;
    @Column(name="end_age")
    int endAge = 100;
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

    public TaxiPot(float start_longtitude, float start_latitude, float end_longtitude, float end_latitude, long departTime, boolean gender_man, boolean gender_woman, int start_age, int end_age, String first_seat, String second_seat, String third_seat, String fourth_seat) {
        this.start_longtitude = start_longtitude;
        this.start_latitude = start_latitude;
        this.end_longtitude = end_longtitude;
        this.end_latitude = end_latitude;
        this.departTime = departTime;
        this.gender_man = gender_man;
        this.gender_woman = gender_woman;
        this.startAge = start_age;
        this.endAge = end_age;
        this.first_seat = first_seat;
        this.second_seat = second_seat;
        this.third_seat = third_seat;
        this.fourth_seat = fourth_seat;
    }
    public TaxiPot(long departTime) {
        this.start_longtitude = 0f;
        this.start_latitude = 0f;
        this.end_longtitude = 0f;
        this.end_latitude = 0f;
        this.departTime = departTime;
        this.gender_man = true;
        this.gender_woman = true;
        this.startAge = 0;
        this.endAge = 100;
        this.first_seat = null;
        this.second_seat = null;
        this.third_seat = null;
        this.fourth_seat = null;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public String getFirst_seat() {
        return first_seat;
    }

    public String getSecond_seat() {
        return second_seat;
    }

    public String getThird_seat() {
        return third_seat;
    }

    public String getFourth_seat() {
        return fourth_seat;
    }

    public float getStart_longtitude() {
        return start_longtitude;
    }

    public float getStart_latitude() {
        return start_latitude;
    }

    public float getEnd_longtitude() {
        return end_longtitude;
    }

    public float getEnd_latitude() {
        return end_latitude;
    }

    public boolean isGender_man() {
        return gender_man;
    }

    public boolean isGender_woman() {
        return gender_woman;
    }

    public int getStart_age() {
        return startAge;
    }

    public int getEnd_age() {
        return endAge;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"departTime\": " +
                departTime +
                "\n" +
                "  \"end_age\": " +
                endAge +
                "\n" +
                "  \"end_latitude\": " +
                end_latitude +
                "\n" +
                "  \"end_longtitude\": " +
                end_longtitude +
                "\n" +
                "  \"first_seat\": " +
                first_seat +
                "\n" +
                "  \"fourth_seat\": " +
                fourth_seat +
                "\n" +
                "  \"gender_man\": " +
                gender_man +
                "\n" +
                "  \"gender_woman\": " +
                gender_woman +
                "\n" +
                "  \"room_id\": " +
                room_id +
                "\n" +
                "  \"second_seat\": " +
                second_seat +
                "\n" +
                "  \"start_age\": " +
                startAge +
                "\n" +
                "  \"start_latitude\": " +
                start_latitude +
                "\n" +
                "  \"start_longtitude\": " +
                start_longtitude +
                "\n" +
                "  \"third_seat\": " +
                third_seat +
                "\n" +
                "}";
    }

    public History toHistory(String userId) {
        EmbeddedHistory key = new EmbeddedHistory(userId,room_id);
        return new History(key,first_seat,second_seat,third_seat,fourth_seat,start_longtitude,start_latitude,end_longtitude,end_latitude,departTime);
    }
}
