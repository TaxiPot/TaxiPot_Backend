package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "report")
@IdClass(ReportKey.class)
public class Report {
    @Id
    @Column(name = "report_user_id")
    String reportUserId;
    @Id
    @Column(name = "reported_user_id")
    String reportedUserId;

    int reason_num;

    public Report() {
    }

    public Report(String reportUserId, String reportedUserId, int reason_num) {
        this.reportUserId = reportUserId;
        this.reportedUserId = reportedUserId;
        this.reason_num = reason_num;
    }

    public String getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportedUserId() {
        return reportedUserId;
    }

    public void setReportedUserId(String reportedUserId) {
        this.reportedUserId = reportedUserId;
    }

    public int getReason_num() {
        return reason_num;
    }

    public void setReason_num(int reason_num) {
        this.reason_num = reason_num;
    }
}
