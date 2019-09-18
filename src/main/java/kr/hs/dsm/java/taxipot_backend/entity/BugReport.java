package kr.hs.dsm.java.taxipot_backend.entity;


import javax.persistence.*;

@Entity
@Table(name = "bugreport")
public class BugReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer bug_id;
    String user_id;
    String content;
}
