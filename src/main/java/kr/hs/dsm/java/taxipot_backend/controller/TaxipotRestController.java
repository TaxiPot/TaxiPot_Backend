package kr.hs.dsm.java.taxipot_backend.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.exception.NotFoundException;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(method = RequestMethod.GET, path = "/findRoom")
    public List<TaxiPot> findTaxipotList(@RequestParam long depart_time, @RequestParam float start_latitude, @RequestParam float start_longitude, @RequestParam float end_latitude, @RequestParam float end_longitude, @RequestParam float radius, @RequestParam int age){
        List<TaxiPot> list = taxipotRepository.findByDepartTimeGreaterThanEqualAndEndAgeGreaterThanEqualAndAndStartAgeIsLessThanEqual(depart_time,age,age);
        List<TaxiPot> correctList = new ArrayList<>();
        for(TaxiPot item : list) {
            if(isInRadious(start_longitude,item.getStart_longtitude(),start_latitude,item.getStart_latitude(),radius)&&isInRadious(end_longitude,item.getEnd_longtitude(),end_latitude,item.getEnd_latitude(),radius)) {
                correctList.add(item);
            }
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public TaxiPot test() {
        return taxipotRepository.save(new TaxiPot(new Date(2020,3,5).getTime()));
    }

    private double getCoordinates(float x, float y){
        return Math.pow((double)x,2) + Math.pow((double)y,2);
    }

    private boolean isInRadious(float x1, float x2, float y1, float y2, float radius) {
        return Math.pow((double)radius,2) >= getCoordinates(x1-x2,y1-y2);
    }

}
