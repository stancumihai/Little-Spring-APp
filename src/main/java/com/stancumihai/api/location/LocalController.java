package com.stancumihai.api.location;

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

    // TODO: 4/5/2021 FixThis
    @PostMapping
    public Local create(@RequestBody Local local) {
        return localService.create(local);
    }


    /**
     * It works
     */
    @GetMapping
    public List<Local> selectAll() {
        return localService.selectAll();
    }

    /**
     * It works
     */
    @GetMapping("{id}")
    public Local findById(@PathVariable("id") Long id) {
        return localService.findById(id);
    }

    /**
     * It works
     */
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return localService.delete(id);
    }

    // TODO: 4/5/2021 FixThis
    @PutMapping("{id}")
    public Local update(@PathVariable("id") Long id, @RequestBody Local local) {
        return localService.update(id, local);
    }

}


