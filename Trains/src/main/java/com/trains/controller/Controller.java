package com.trains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trains.services.ITrainsService;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private ITrainsService trainService;

	@GetMapping(value = "/calculateDistance/{route}")
	public ResponseEntity<String> calculateDistance(@PathVariable(value = "route") String route) throws Exception {
		try {
			return new ResponseEntity<String>("The distance for the " + route + " is: " + this.trainService.getDistance(route), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
