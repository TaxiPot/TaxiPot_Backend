package kr.hs.dsm.java.taxipot_backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class EmbeddedHistory implements Serializable {
    @Column(name = "user_id")
    String userId;
    @Column(name = "room_id")
    Integer roomId;

    public EmbeddedHistory() {
    }

    public EmbeddedHistory(String userId, Integer roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }


}
