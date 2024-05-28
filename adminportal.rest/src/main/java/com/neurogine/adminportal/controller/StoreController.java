package com.neurogine.adminportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.adminportal.model.Store;
import com.neurogine.adminportal.service.IStoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	IStoreService storeService;

	@PostMapping("/new")
	public ResponseEntity<Object> create(@RequestBody Store store) {
		store = storeService.create(store);
		return new ResponseEntity<Object>(store, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {

		Store product = storeService.getById(id);
		return new ResponseEntity<Object>(product, HttpStatus.OK);

	}

	@PutMapping("/edit")
	public ResponseEntity<Object> edit(@RequestBody Store store) {
		store = storeService.update(store);

		return new ResponseEntity<Object>(store, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<Object> get(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name) {
		Store queryStore = new Store();
		queryStore.setId(id);
		queryStore.setName(name);
		List<Store> storeList = storeService.get(queryStore);
		return new ResponseEntity<Object>(storeList, HttpStatus.OK);

	}

}
