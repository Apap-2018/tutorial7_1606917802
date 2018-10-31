package com.apap.tutorial7.service;
import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;

public interface CarService {
	CarModel addCar(CarModel car);
	public void deleteById(Long id);
	void updateCar(long id,CarModel car);
	CarModel getCar(Long id);
	void deleteCar(CarModel car);
	List<CarModel> viewAll();
}

