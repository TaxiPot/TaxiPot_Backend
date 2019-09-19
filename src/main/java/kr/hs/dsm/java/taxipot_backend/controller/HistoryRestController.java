package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.History;
import kr.hs.dsm.java.taxipot_backend.exception.AlreadyExistException;
import kr.hs.dsm.java.taxipot_backend.exception.NotFoundException;
import kr.hs.dsm.java.taxipot_backend.repository.HistoryRepository;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class HistoryRestController {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/history")
    public int save(@RequestBody List<History> historyList, @PathVariable("id") String id) {
        int saveCount=0;
        if (userRepository.findById(id) == null) {
            throw new NotFoundException("존재하지 않는 유저입니다.");
        }
        for(History item : historyList) {
            if(historyRepository.findById(item.getUserRoomId()).isPresent()) { } else {
                historyRepository.save(item);
                saveCount++;
            }
        }
        return saveCount;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}/history")
    public List<History> findHistoriesById(@PathVariable("id") String id) {
        return historyRepository.findHistoriesByUserRoomIdUserId(id);
    }
}
