package com.A6.bikecurd.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.A6.bikecurd.entity.Bike;
import com.A6.bikecurd.repository.BikeRepository;
@Controller	
public class BikeController {
	@Autowired
	BikeRepository repository;
	@GetMapping("/")
	public String loadMain() {
		return "main.html";
	}
	@GetMapping("/insert")
	public String loadInsertForm(ModelMap map) {
	    map.put("bike", new Bike());  // Add this line
	    return "insert.html";
	}
	@PostMapping("/insert")
	public String saveRecord(Bike bike, ModelMap map) {
		repository.save(bike);
		map.put("message", "Bike Added Successfully");
		return "main.html";
	}
	@GetMapping("/fetch")
	public String fetch(ModelMap map) {
		List<Bike> bikes = repository.findAll();
		map.put("bikes", bikes);
		return "fetch.html";
	}
	@GetMapping("/delete")
	public String removeById(@RequestParam Long id, ModelMap map) {
		repository.deleteById(id);
		map.put("message", "Record Deleted");
		return fetch(map);
	}
	@GetMapping("/update")
	public String getUpdateForm(@RequestParam Long id, ModelMap map) {
		Optional<Bike> optionalBike = repository.findById(id);
		if (optionalBike.isPresent()) {
			map.put("bike", optionalBike.get());
			return "update.html";
		} else {
			map.put("message", "Bike not found");
			return "main.html";
		}}
	@PostMapping("/update")
	public String saveUpdate(Bike bike, ModelMap map) {
		repository.save(bike);
		map.put("message", "Bike Updated Successfully");
		return fetch(map);
	}}
