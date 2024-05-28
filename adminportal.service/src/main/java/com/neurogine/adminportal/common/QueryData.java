package com.neurogine.adminportal.common;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class QueryData<T> implements Serializable {

	private static final long serialVersionUID = -1387883074695980451L;
	private Predicate[] predicates;
	private CriteriaBuilder cb;
	private Integer numberOfRows;
	private Integer offset;
	private Map<String, String> orderBy;
	private Root<T> rt;

	public Predicate[] getPredicates() {
		return predicates;
	}

	public void setPredicates(Predicate[] predicates) {
		this.predicates = predicates;
	}

	public CriteriaBuilder getCb() {
		return cb;
	}

	public void setCb(CriteriaBuilder cb) {
		this.cb = cb;
	}

	public Integer getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(Integer numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Map<String, String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Map<String, String> orderBy) {
		this.orderBy = orderBy;
	}

	public Root<T> getRt() {
		return rt;
	}

	public void setRt(Root<T> rt) {
		this.rt = rt;
	}

}
