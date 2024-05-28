package com.neurogine.adminportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurogine.adminportal.model.Store;
import com.neurogine.adminportal.repository.IStoreRepository;

@Service
public class StoreService implements IStoreService {

	@Autowired
	IStoreRepository storeRepository;

	@Override
	public Store create(Store store) {
		store = storeRepository.create(store);
		return store;
	}

	@Override
	public Store update(Store store) {
		store = storeRepository.update(store);
		return store;
	}

	@Override
	public Store getById(Long id) {
		Store store = storeRepository.getById(id);
		return store;
	}

	@Override
	public Integer deleteById(Long id) {
		Integer updatedRows = storeRepository.deleteById(id);
		return updatedRows;
	}

	@Override
	public List<Store> get(Store store) {

		List<Store> productList = storeRepository.get(store);
		return productList;
	}

}
