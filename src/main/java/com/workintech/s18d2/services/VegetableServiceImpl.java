package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if (vegetable.getName() == null || vegetable.getName().trim().isEmpty()) {
            throw new PlantException("Vegetable name cannot be empty.", HttpStatus.BAD_REQUEST);
        }
        if (vegetable.getPrice() < 1) {
            throw new PlantException("Vegetable price must be at least 1.", HttpStatus.BAD_REQUEST);
        }
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(Long id) {
        if (id == null || id < 1) {
            throw new PlantException("ID must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable not found. ID: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable delete(Long id) {
        if (id == null || id < 1) {
            throw new PlantException("ID must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        Vegetable found = vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable not found. ID: " + id, HttpStatus.NOT_FOUND));
        vegetableRepository.delete(found);
        return found;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}



/* package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(Long id) {
        return vegetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable found = vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable bulunamadı. ID: " + id, HttpStatus.NOT_FOUND));

        vegetableRepository.deleteById(id);
        return found;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
} */
