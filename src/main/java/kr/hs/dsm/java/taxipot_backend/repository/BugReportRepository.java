package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.BugReport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BugReportRepository extends CrudRepository<BugReport, Integer> {
    List<BugReport> findAll();
}
