package kr.hs.dsm.java.taxipot_backend.entity;

import java.io.Serializable;

public class EmbeddedHistory implements Serializable {
    String user_id;
    int room_id;

    public EmbeddedHistory() {
    }

    public EmbeddedHistory(String user_id, int room_id) {
        super();
        this.user_id = user_id;
        this.room_id = room_id;
    }
}
