package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class TaxipotRestController {
    @Autowired
    TaxipotRepository repository;

    @GetMapping
    public List<TaxiPot> findAll() {
        return repository.findAll();
    }
}
