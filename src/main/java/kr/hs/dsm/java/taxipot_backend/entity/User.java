package kr.hs.dsm.java.taxipot_backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    long id;
    public User(int id){
        this.id = id;
    }

    public User(){}

    public long getId() {
        return id;
    }
}
