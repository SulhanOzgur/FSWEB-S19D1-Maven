package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.services.VegetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    // [GET] /workintech/vegetables
    @GetMapping
    public List<Vegetable> getAllAsc() {
        return vegetableService.getByPriceAsc();
    }

    // [GET] /workintech/vegetables/{id}
    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    // [GET] /workintech/vegetables/desc
    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getByPriceDesc();
    }

    // [POST] /workintech/vegetables
    @PostMapping
    public Vegetable saveOrUpdate(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    // [POST] /workintech/vegetables/{name}
    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    // [DELETE] /workintech/vegetables/{id}
    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}