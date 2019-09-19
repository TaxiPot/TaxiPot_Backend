package kr.hs.dsm.java.taxipot_backend.controller;


import kr.hs.dsm.java.taxipot_backend.entity.Report;
import kr.hs.dsm.java.taxipot_backend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    @Autowired
    ReportRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Report> findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/report")
    public List<Report> report(@RequestBody Report report) {
        System.out.println(report.getReportUserId());
        repository.save(report);
        return repository.findReportsByReportUserId(report.getReportUserId());
    }
}
