package kr.hs.dsm.java.taxipot_backend.controller;


import kr.hs.dsm.java.taxipot_backend.entity.Report;
import kr.hs.dsm.java.taxipot_backend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    @Autowired
    ReportRepository repository;

    @GetMapping
    public List<Report> findAll() {
        return repository.findAll();
    }
}
