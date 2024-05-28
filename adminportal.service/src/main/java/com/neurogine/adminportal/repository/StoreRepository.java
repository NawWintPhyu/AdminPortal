package com.neurogine.adminportal.repository;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.neurogine.adminportal.common.CommonUtils;
import com.neurogine.adminportal.enumeration.Category;
import com.neurogine.adminportal.model.Store;

@Repository
public class StoreRepository extends DataAccessManager implements IStoreRepository {
	private static final String GET_STORE_BY_ID = "store.getById";
	private static final String DELETE_STORE_BY_ID = "store.deleteById";

	@Override
	public Store create(Store store) {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(store);

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return store;
	}

	@Override
	public Store update(Store store) {

		if (store != null && store.getId() != null) {
			Store storeTemp = getById(store.getId());
			EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			if (store.getName() != null) {
				storeTemp.setName(store.getName());
			}
			if (store.getAddress() != null) {
				storeTemp.setAddress(store.getAddress());
			}
			if (store.getCategory() != null) {
				storeTemp.setCategory(store.getCategory());
			}
			if (store.getDescription() != null) {
				storeTemp.setDescription(store.getDescription());
			}
			if (store.getEmailAddress() != null) {
				storeTemp.setEmailAddress(store.getEmailAddress());
			}
			if (store.getGeolocationLatitude() != null) {
				storeTemp.setGeolocationLatitude(store.getGeolocationLatitude());
			}
			if (store.getGeolocationLongitude() != null) {
				storeTemp.setGeolocationLongitude(store.getGeolocationLongitude());
			}
			if (store.getImage() != null) {
				storeTemp.setImage(store.getImage());
			}
			store = entityManager.merge(storeTemp);
			entityTransaction.commit();
			entityManager.close();
			entityManagerFactory.close();
			setEnityManagerFactoryNull();
		}

		return store;
	}

	@Override
	public Store getById(Long id) {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNamedQuery(GET_STORE_BY_ID);
		query.setParameter(1, id);
		List<Store> storeList = (List<Store>) query.getResultList();
		Store store = null;
		if (storeList.size() > 0) {
			store = storeList.get(0);
		}
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return store;
	}

	@Override
	public Integer deleteById(Long id) {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNamedQuery(DELETE_STORE_BY_ID);
		query.setParameter(1, id);
		int updatedRows = query.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return updatedRows;
	}

	@Override
	public List<Store> get(Store store) {
		List<Store> storeList = null;
		if (store != null) {
			EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			List<Predicate> predList = new LinkedList<Predicate>();
			Predicate[] predicateArray = null;

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Store> criteriaQuery = cb.createQuery(Store.class);
			Root<Store> root = criteriaQuery.from(Store.class);

			if (store.getId() != null) {
				Path<Long> id = root.<Long>get("id");
				Long searchId = store.getId();
				Predicate predicate = cb.and(cb.equal(id, searchId));
				predList.add(predicate);
			}

			if (store.getName() != null && store.getName().trim().isEmpty() != false) {
				Path<String> name = root.<String>get("name");
				String searchName = store.getName();
				Predicate predicate = cb.and(cb.equal(name, searchName));
				predList.add(predicate);
			}
			if (store.getCategory() != null) {
				Path<String> category = root.<String>get("category");
				Category searchCategory = store.getCategory();
				Predicate predicate = cb.and(cb.equal(category, searchCategory));
				predList.add(predicate);
			}

			predicateArray = CommonUtils.getArrayFromList(Predicate.class, predList);
			criteriaQuery.where(predicateArray);
			TypedQuery<Store> query = entityManager.createQuery(criteriaQuery);
			storeList = query.getResultList();

			entityTransaction.commit();
			entityManager.close();
			entityManagerFactory.close();
			setEnityManagerFactoryNull();
		}
		return storeList;
	}

}
