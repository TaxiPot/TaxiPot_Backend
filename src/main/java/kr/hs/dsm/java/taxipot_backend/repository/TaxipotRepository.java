package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaxipotRepository extends CrudRepository<TaxiPot, Integer> {
    List<TaxiPot> findAll();
    List<TaxiPot> findByDepartTimeLessThanEqual(long depart_time);
    List<TaxiPot> findByDepartTimeGreaterThanEqualAndEndAgeGreaterThanEqualAndAndStartAgeIsLessThanEqual(long depart_time, int endAge, int startAge);
}