package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaxipotRepository extends CrudRepository<TaxiPot, Long> {
    public List<TaxiPot> findAll();
}
