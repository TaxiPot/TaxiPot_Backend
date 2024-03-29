package kr.hs.dsm.java.taxipot_backend.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.entity.User;
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
    public TaxiPot makeTaxipot(@RequestBody TaxiPot taxiPot) {
        return taxipotRepository.save(taxiPot);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "유저 아이디 혹은 방을 찾을 수 없음.")
    })
    @RequestMapping(method = RequestMethod.PATCH, path = "/{roomId}/join")
    public TaxiPot joinTaxipot(@PathVariable("roomId")Integer roomId, @RequestParam(name = "user_id") String userId, @RequestParam(name = "seat_num")int seatNum) {
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()) {
            throw new NotFoundException("유저 아이디를 찾을 수 없음.");
        }
        User user = optUser.get();
        Optional<TaxiPot> joinPot = taxipotRepository.findById(roomId);
        if(joinPot.isPresent()) {
            user.setRoomId(roomId);
            user.setSeatNum(seatNum);
            System.out.println(user.toString());
            userRepository.save(user);
            switch (seatNum) {
                case 0 : {joinPot.get().setFirst_seat(userId); break;}
                case 1 : {joinPot.get().setSecond_seat(userId); break;}
                case 2 : {joinPot.get().setThird_seat(userId); break;}
                case 3 : {joinPot.get().setFourth_seat(userId); break;}
            }
            taxipotRepository.save(joinPot.get());
        } else {
            throw new NotFoundException("방을 찾을 수 없음");
        }
        return joinPot.get();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findRoom")
    public List<TaxiPot> findTaxipotList(@RequestParam long depart_time, @RequestParam float start_latitude, @RequestParam float start_longitude, @RequestParam float end_latitude, @RequestParam float end_longitude, @RequestParam float radius, @RequestParam int age, @RequestParam boolean isMan){
        System.out.println("departTime : " + depart_time + " start_latitude : " + start_latitude + " startLongitude : " + start_longitude + " endLatitude : " +end_latitude + " endLongitude : " + end_longitude + " radius : " + radius + "age : " + age + "isMan : " + isMan);
        List<TaxiPot> list = taxipotRepository.findByDepartTimeGreaterThanEqualAndEndAgeGreaterThanEqualAndAndStartAgeIsLessThanEqual(depart_time,age,age);
        List<TaxiPot> correctList = new ArrayList<>();
        for(TaxiPot item : list) {
            //System.out.println("filtering... \n before taxiPot : " + item.toString() + "\n");
            if(isMan == item.isGender_man() || (!isMan) == item.isGender_woman()) {
                System.out.println("start distance : " + getCoordinates(item.getStart_longtitude() - start_longitude, item.getStart_latitude() - start_latitude) + "\narrive distance : " + getCoordinates(item.getEnd_longtitude() - start_longitude, item.getEnd_latitude() - start_latitude) + "\n");
                if (isInRadious(start_longitude, item.getStart_longtitude(), start_latitude, item.getStart_latitude(), radius) && isInRadious(end_longitude, item.getEnd_longtitude(), end_latitude, item.getEnd_latitude(), radius)) {
                    correctList.add(item);
                    System.out.println("add : " + item.toString() + "\n");
                } else {
                    System.out.println("remove : " + item.toString() + "\n");
                }
            }
        }
        System.out.println("result : " + correctList);
        return correctList;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public TaxiPot test() {
        return taxipotRepository.save(new TaxiPot(new Date().getTime()));
    }

    private double getCoordinates(float x, float y){
        return Math.pow((double)x,2) + Math.pow((double)y,2);
    }

    private boolean isInRadious(float x1, float x2, float y1, float y2, float radius) {
        return Math.pow((double)radius,2) >= getCoordinates(x1-x2,y1-y2);
    }

}
