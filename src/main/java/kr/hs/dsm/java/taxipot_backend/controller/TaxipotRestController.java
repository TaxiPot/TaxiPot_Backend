package kr.hs.dsm.java.taxipot_backend.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.exception.NotFoundException;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class TaxipotRestController {
    @Autowired
    TaxipotRepository taxipotRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<TaxiPot> findAll() {
        return taxipotRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/makeroom")
    public void makeTaxipot(@RequestBody TaxiPot taxiPot) {
        taxipotRepository.save(taxiPot);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "유저 아이디 혹은 방을 찾을 수 없음.")
    })
    @RequestMapping(method = RequestMethod.PATCH, path = "/{roomId}/join")
    public void joinTaxipot(@PathVariable("roomId")Integer roomId, @RequestParam(name = "user_id") String userId, @RequestParam(name = "seat_num")int seatNum) {
        if(!userRepository.findById(userId).isPresent()) {
            throw new NotFoundException("유저 아이디를 찾을 수 없음.");
        }
        Optional<TaxiPot> joinPot = taxipotRepository.findById(roomId);
        if(joinPot.isPresent()) {
            switch (seatNum) {
                case 1 : {joinPot.get().setFirst_seat(userId); break;}
                case 2 : {joinPot.get().setSecond_seat(userId); break;}
                case 3 : {joinPot.get().setThird_seat(userId); break;}
                case 4 : {joinPot.get().setFourth_seat(userId); break;}
            }
            taxipotRepository.save(joinPot.get());
        } else {
            throw new NotFoundException("방을 찾을 수 없음");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/join")
    public List<TaxiPot> findTaxipotList(){
        return taxipotRepository.findAll();
    }
}
