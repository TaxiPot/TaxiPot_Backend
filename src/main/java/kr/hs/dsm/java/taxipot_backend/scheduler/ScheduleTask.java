package kr.hs.dsm.java.taxipot_backend.scheduler;

import kr.hs.dsm.java.taxipot_backend.entity.EmbeddedHistory;
import kr.hs.dsm.java.taxipot_backend.entity.History;
import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.repository.HistoryRepository;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleTask {
    private static Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일 hh시 mm분 ss초");
    @Autowired
    private TaxipotRepository taxipotRepository;
    @Autowired
    private HistoryRepository historyRepository;

    @Scheduled(cron = "*/15 * * * * *")
    public void saveAllHistory() {
        Date date = new Date();
        logger.info("현재 시각 : {}", dateFormat.format(date));
        List<TaxiPot> saveHistoryList = taxipotRepository.findByDepartTimeLessThanEqual(date.getTime());
        logger.info("History에 저장할 방 목록 : {}", saveHistoryList);
        for (TaxiPot item : saveHistoryList) {
            saveToHistory(historyBuild(item.getFirst_seat(), item));
            saveToHistory(historyBuild(item.getSecond_seat(), item));
            saveToHistory(historyBuild(item.getThird_seat(), item));
            saveToHistory(historyBuild(item.getFourth_seat(), item));
        }
    }

    private History historyBuild(String userId, TaxiPot item) {
        if (userId != null) {
            return new History(new EmbeddedHistory(userId, item.getRoom_id()), item.getFirst_seat(), item.getSecond_seat(), item.getThird_seat(), item.getFourth_seat());
        } else {
            return null;
        }
    }

    private void saveToHistory(History item) {
        if (item != null) {
            historyRepository.save(item);
        }
    }
}
