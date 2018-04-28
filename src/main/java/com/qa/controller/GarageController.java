package com.qa.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.Garage;
import com.qa.repository.GarageRepository;

@RestController
@RequestMapping("api/v1/")
public class GarageController {
	
	@Autowired
	private GarageRepository garageRepository;

	@RequestMapping(value = "garages", method = RequestMethod.GET)
	public List<Garage> list() {
		return garageRepository.findAll();
	}

	@RequestMapping(value = "garages", method = RequestMethod.POST)
	public Garage create(@RequestBody Garage garage) {
		return garageRepository.saveAndFlush(garage);
	}

	@RequestMapping(value = "garages/{id}", method = RequestMethod.GET)
	public Garage get(@PathVariable Long id) {
		return garageRepository.findOne(id);
	}

	@RequestMapping(value = "garages/{id}", method = RequestMethod.PUT)
	public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
		Garage existingGarage = garageRepository.findOne(id);
		BeanUtils.copyProperties(garage, existingGarage);
		return garageRepository.saveAndFlush(existingGarage);
	}

	@RequestMapping(value = "garages/{id}", method = RequestMethod.DELETE)
	public Garage delete(@PathVariable Long id) {
		Garage existingGarage = garageRepository.findOne(id);
		garageRepository.delete(existingGarage);
		return existingGarage;
	}
	
}
