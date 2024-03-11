package org.TableBookingSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Service.CuisineService;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CuisineController {

	@Autowired
    private CuisineService cuisineService;
	

    @GetMapping
    public List<Cuisine> getAllCuisines() {
        return cuisineService.getAllCuisines();
        
    }
    @GetMapping("/{id}")
    public Optional<Cuisine> getCuisineById(@PathVariable Long cuisineId) {
        return cuisineService.getCuisineById(cuisineId);
    }
    
    @PostMapping
    public Cuisine addCuisine(@RequestBody Cuisine cuisine) {
        return cuisineService.addCuisine(cuisine);
    }
    
}
