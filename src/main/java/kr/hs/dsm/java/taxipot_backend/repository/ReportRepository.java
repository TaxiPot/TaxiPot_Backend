package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.Report;
import kr.hs.dsm.java.taxipot_backend.entity.ReportKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, ReportKey> {
    List<Report> findAll();
    List<Report> findReportsByReportUserId(String report_id);
}
