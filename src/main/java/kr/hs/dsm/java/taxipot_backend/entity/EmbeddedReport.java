package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
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
}
