package com.stancumihai.api.sport;

import com.stancumihai.model.Sport;
import com.stancumihai.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sport/api")
public class SportController {

    private final SportService service;

    @Autowired
    public SportController(SportService service) {
        this.service = service;
    }

    @PutMapping("{id}")
    public Sport update(@PathVariable("id") Long id, @RequestBody Sport sport) {
        return service.update(id, sport);
    }

    @PostMapping()
    public int create(@RequestBody Sport element) {
        return service.create(element);
    }

    @GetMapping("{id}")
    public Sport findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public int deleteById(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<Sport> selectAll() {
        return service.selectAll();
    }
}
