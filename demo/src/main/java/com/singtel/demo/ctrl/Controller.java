package com.singtel.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singtel.demo.service.AnimalService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/animal")
@RestController
public class Controller {

	@Autowired
	public AnimalService animalService;

	
	@ApiOperation(value = "count of animals that can fly")
	@RequestMapping(value = "/flyCount", method = RequestMethod.GET)
	public Long flyCount() {
		return animalService.flyCount();
	}

	@ApiOperation(value = "count of animals that can walk")
	@RequestMapping(value = "/walkCount", method = RequestMethod.GET)
	public Long walkCount() {
		return animalService.walkCount();
	}

	@ApiOperation(value = "count of animals that can sing")
	@RequestMapping(value = "/singCount", method = RequestMethod.GET)
	public Long singCount() {
		return animalService.singCount();
	}

	@ApiOperation(value = "count of animals that can swim")
	@RequestMapping(value = "/swimCount", method = RequestMethod.GET)
	public Long swimCount() {
		return animalService.swimCount();
	}

}
