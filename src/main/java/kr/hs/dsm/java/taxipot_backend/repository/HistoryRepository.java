package kr.hs.dsm.java.taxipot_backend.repository;

import kr.hs.dsm.java.taxipot_backend.entity.EmbeddedHistory;
import kr.hs.dsm.java.taxipot_backend.entity.History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History, EmbeddedHistory> {
    public List<History> findAll();
    public List<History> findHistoriesByUserRoomIdUserId(String userId);
}
