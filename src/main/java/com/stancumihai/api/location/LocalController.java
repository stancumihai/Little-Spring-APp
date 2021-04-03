package com.stancumihai.api.location;


import com.stancumihai.model.Country;
import com.stancumihai.model.Local;
import com.stancumihai.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("local/api")
public class LocalController {


    private final LocalService localService;

    @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @PostMapping
    public int create(@RequestBody Local local) {
        return localService.create(local);
    }

    @GetMapping
    public List<Local> selectAll() {
        return localService.selectAll();
    }

    @GetMapping("{id}")
    public Local findById(@PathVariable("id") Long id) {
        return localService.findById(id);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return localService.delete(id);
    }

    @PutMapping("{id}")
    public Local update(@PathVariable("id") Long id, @RequestBody Local local) {
        return localService.update(id, local);
    }
}


