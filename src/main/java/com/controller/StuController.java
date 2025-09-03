package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bean.StuData;
import com.service.StuService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
public class StuController {

	@Autowired
	StuService serv;

	@PostMapping("/savedata")
	public ResponseEntity<String> saveData(@RequestBody StuData data) {

		if (serv.saveData(data) == null) {
			return ResponseEntity.ok("process ended");
		} else {
			return serv.saveData(data);
		}
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<StuData> getMethodName(@PathVariable int id) {
		if (serv.getBYId(id) == null) {
			return ResponseEntity.ok(serv.getBYId(id));
		} else {
			return ResponseEntity.ok(serv.getBYId(id));
		}
	}

	@GetMapping("/get")
	public List<StuData> getMethodName(@RequestParam String name, @RequestParam String area) {

		return serv.getByNameArea(name, area);

	}

	@PutMapping("/path")
	public ResponseEntity<Integer> putMethodName(@RequestParam("id") int id,
			                                     @RequestParam("name") String name) {

		return ResponseEntity.ok(serv.updateName(name, id));
	}

}
