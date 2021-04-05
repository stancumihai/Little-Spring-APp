package com.stancumihai.api.location;

import com.stancumihai.model.Location;
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

    // TODO: 4/5/2021 FixThis
    @PostMapping
    public int create(@RequestBody Region region) {
        return regionService.create(region);
    }

    /**
     * It works
     */
    @GetMapping
    public List<Region> selectAll() {
        return regionService.selectAll();
    }

    /**
     * It works
     */
    @GetMapping("{id}")
    public Region findById(@PathVariable("id") Long id) {
        return regionService.findById(id);
    }

    /**
     * It works
     */
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return regionService.delete(id);
    }

    // TODO: 4/5/2021 FixThis
    @PutMapping("{id}")
    public Region update(@PathVariable("id") Long id, @RequestBody Region region) {
        return regionService.update(id, region);
    }

}


