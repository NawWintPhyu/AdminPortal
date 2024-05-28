package com.neurogine.adminportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neurogine.adminportal.model.Store;

@Service
public interface IStoreService {
	public Store create(Store product);

	public Store update(Store product);

	public Store getById(Long id);

	public List<Store> get(Store product);

	public Integer deleteById(Long id);

}
