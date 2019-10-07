package kr.hs.dsm.java.taxipot_backend.entity;

import java.io.Serializable;

public class ReportKey implements Serializable {
    String reportUserId;
    String reportedUserId;

    public ReportKey() {
    }

    public ReportKey(String reportUserId, String reportedUserId) {
        this.reportUserId = reportUserId;
        this.reportedUserId = reportedUserId;
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
}
