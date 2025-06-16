package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {

       /*  if (fruit.getName() == null || fruit.getName().trim().isEmpty()) {
            throw new PlantException("Fruit name cannot be empty.", HttpStatus.BAD_REQUEST);
        }
        if (fruit.getPrice() < 1) {
            throw new PlantException("Fruit price must be at least 1.", HttpStatus.BAD_REQUEST);
        }
        if (fruit.getFruitType() == null) {
            throw new PlantException("Fruit type is required.", HttpStatus.BAD_REQUEST);
        } */
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        if (id == null || id < 1) {
            throw new PlantException("ID must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found. ID: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit delete(Long id) {
        if (id == null || id < 1) {
            throw new PlantException("ID must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        Fruit found = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found. ID: " + id, HttpStatus.NOT_FOUND));
        fruitRepository.delete(found);
        return found;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}



/* package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit delete(Long id) {
        Fruit found = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit bulunamadı. ID: " + id, HttpStatus.NOT_FOUND));

        fruitRepository.deleteById(id);
        return found;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
} */
