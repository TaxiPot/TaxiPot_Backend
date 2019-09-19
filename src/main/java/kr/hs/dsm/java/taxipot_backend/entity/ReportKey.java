package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*@Embeddable
public class EmbeddedReport implements Serializable {
    String report_user_id;
    String reported_user_id;

    public EmbeddedReport() {
    }

    public EmbeddedReport(String report_user_id, String reported_user_id) {
        super();
        this.report_user_id = report_user_id;
        this.reported_user_id = reported_user_id;
    }

    public String getReport_user_id() {
        return report_user_id;
    }

    public void setReport_user_id(String report_user_id) {
        this.report_user_id = report_user_id;
    }

    public String getReported_user_id() {
        return reported_user_id;
    }

    public void setReported_user_id(String reported_user_id) {
        this.reported_user_id = reported_user_id;
    }
}*/

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
