package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    ArrayList<User> findAll();
    User save(User user);
}
