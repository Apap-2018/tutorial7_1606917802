package com.apap.tutorial7.controller;
import com.apap.tutorial7.model.*;
import com.apap.tutorial7.service.*;
import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model){
		return carService.viewAll();
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable("carId") long id, Model model) {
		return carService.getCar(id);
	}
	
	@DeleteMapping(value="/delete")
	private String deleteCar(@RequestParam("carId") long id, Model model) {
		carService.deleteById(id);
		return "car has been deleted";
	}
	
	@PutMapping(value="/{carId}")
	private String updateCarSubmit(@PathVariable(value="carId") long id, 
			@RequestParam("brand") String brand, 
			@RequestParam("type") String type, 
			@RequestParam("price") String price, 
			@RequestParam("amount") String amount, 
			@RequestParam("dealerId") Long dealerId) {
		CarModel car = (CarModel) carService.getCar(id);
		if(car.equals(null)) {
			return "Couldnt find your car";
		}
		if(amount!=""){car.setAmount(amount);}
		if(brand!="") {car.setBrand(brand);}
		if(price!="") {car.setPrice(price);}
		if(type!="") {car.setType(type);}
		if(dealerId!=null){car.setDealer(dealerService.getDealerDetailById(dealerId).get());}
		carService.updateCar(id, car);
		return "Update Success";
	}
	
	@PostMapping(value="/add")
	private CarModel addCarSubmit(@RequestBody CarModel car, HttpServletRequest req) {
		//car.setDealer(car.getDealer());
		return carService.addCar(car);
	}
}
