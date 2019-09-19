package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.BugReport;
import kr.hs.dsm.java.taxipot_backend.repository.BugReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugReportController {
    @Autowired
    BugReportRepository repository;
    @RequestMapping(method = RequestMethod.GET)
    public List<BugReport> findAll() {
        return repository.findAll();
    }
}
