package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaxipotRepository extends CrudRepository<TaxiPot, Integer> {
    public List<TaxiPot> findAll();
}
