package com.stancumihai.api.sport;

import com.stancumihai.model.Sport;
import com.stancumihai.service.SportLocationsService;
import com.stancumihai.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sport/api")
public class SportController {

    private final SportService sportService;
    private final SportLocationsService sportLocationsService;

    @Autowired
    public SportController(SportService service, SportLocationsService sportLocationsService) {
        this.sportService = service;
        this.sportLocationsService = sportLocationsService;
    }

    @PutMapping("{id}")
    public Sport update(@PathVariable("id") Long id, @RequestBody Sport sport) {
        return sportService.update(id, sport);
    }

    @PostMapping()
    public int create(@RequestBody Sport element) {
        return sportService.create(element);
    }

    @GetMapping("{id}")
    public Sport findById(@PathVariable("id") Long id) {
        return sportService.findById(id);
    }

    @DeleteMapping("{id}")
    public int deleteById(@PathVariable("id") Long id) {
        return sportService.deleteById(id);
    }

    @GetMapping
    public List<Sport> selectAll() {
        return sportService.selectAll();
    }

    @GetMapping("end/{date}")
    public List<Sport> getSportLocationsEndPeriods(@PathVariable("date") String endDate) {
        return sportLocationsService.getSportLocationsEndPeriods(endDate);
    }


    @GetMapping("start/{date}")
    public List<Sport> getSportLocationsStartPeriods(@PathVariable("date") String startDate) {
        return sportLocationsService.getSportLocationsStartPeriods(startDate);
    }
}
