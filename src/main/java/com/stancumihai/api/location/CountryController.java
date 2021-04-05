package com.stancumihai.api.location;


import com.stancumihai.model.Country;
import com.stancumihai.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country/api")
public class CountryController {


    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // TODO: 4/5/2021 Fix this 
    @PostMapping
    public Country create(@RequestBody Country location) {
        return countryService.create(location);
    }

    /**
     * It works
     */
    @GetMapping
    public List<Country> selectAll() {
        return countryService.selectAll();
    }

    /**
     * It works
     */
    @GetMapping("{id}")
    public Country findById(@PathVariable("id") Long id) {
        return countryService.findById(id);
    }


    /**
     * It works
     */
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return countryService.delete(id);
    }

    @PutMapping("{id}")
    public Country update(@PathVariable("id") Long id, @RequestBody Country location) {
        return countryService.update(id, location);
    }

}


