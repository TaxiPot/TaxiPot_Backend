package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.History;
import kr.hs.dsm.java.taxipot_backend.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class HistoryRestController {

    @Autowired
    HistoryRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<History> findAll() {
        return repository.findAll();
    }
}
