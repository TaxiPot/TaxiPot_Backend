package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.EmbeddedReport;
import kr.hs.dsm.java.taxipot_backend.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, EmbeddedReport> {
    public List<Report> findAll();
}
