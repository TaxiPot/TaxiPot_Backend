package kr.hs.dsm.java.taxipot_backend.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bugreport")
public class BugReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bug_id;
    String user_id;
    String content;

    public String getUser_id() {
        return user_id;
    }
}
