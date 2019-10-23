package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.BugReport;
import kr.hs.dsm.java.taxipot_backend.exception.NotFoundException;
import kr.hs.dsm.java.taxipot_backend.repository.BugReportRepository;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BugReportController {

    @Autowired
    BugReportRepository repository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/bugs")
    public List<BugReport> findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/postbug")
    public BugReport postBug(@RequestBody BugReport bugReport) {
        if(userRepository.findById(bugReport.getUser_id()).isPresent()) {
            repository.save(bugReport);
        } else {
            throw new NotFoundException("유저 아이디를 찾을 수 없습니다.");
        }
        return bugReport;
    }
}
