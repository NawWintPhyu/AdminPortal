package com.neurogine.adminportal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neurogine.adminportal.model.Store;

@Repository
public interface IStoreRepository {
	public Store create(Store product);

	public Store update(Store product);

	public Store getById(Long id);

	public List<Store> get(Store product);

	public Integer deleteById(Long id);

}
