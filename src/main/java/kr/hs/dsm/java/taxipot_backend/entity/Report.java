package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
    @EmbeddedId
    EmbeddedReport user_id;
    int reason_num;

    public Report() {
    }

    public Report(EmbeddedReport user_id, int reason_num) {
        this.user_id = user_id;
        this.reason_num = reason_num;
    }

    public EmbeddedReport getUser_id() {
        return user_id;
    }

    public void setUser_id(EmbeddedReport user_id) {
        this.user_id = user_id;
    }

    public int getReason_num() {
        return reason_num;
    }

    public void setReason_num(int reason_num) {
        this.reason_num = reason_num;
    }
}
