package com.stancumihai.api.location;


import com.stancumihai.model.Region;
import com.stancumihai.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("region/api")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping
    public int create(@RequestBody Region region) {
        return regionService.create(region);
    }

    @GetMapping
    public List<Region> selectAll() {
        return regionService.selectAll();
    }

    @GetMapping("{id}")
    public Region findById(@PathVariable("id") Long id) {
        return regionService.findById(id);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return regionService.delete(id);
    }

    @PutMapping("{id}")
    public Region update(@PathVariable("id") Long id, @RequestBody Region region) {
        return regionService.update(id, region);
    }
}


