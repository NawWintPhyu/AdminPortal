package com.neurogine.adminportal.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.neurogine.adminportal.enumeration.Category;

@Entity
@Table(name = "store")
public class Store implements Serializable {
	private static final long serialVersionUID = -5624938845497132672L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "image")
	private MultipartFile image;
	@Column(name = "category")
	private Category category;
	@Column(name = "address", unique = true)
	private String address;
	@Column(name = "geo_location_latitude")
	private Double geolocationLatitude;
	@Column(name = "geo_location_longitude")
	private Double geolocationLongitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getGeolocationLatitude() {
		return geolocationLatitude;
	}

	public void setGeolocationLatitude(Double geolocationLatitude) {
		this.geolocationLatitude = geolocationLatitude;
	}

	public Double getGeolocationLongitude() {
		return geolocationLongitude;
	}

	public void setGeolocationLongitude(Double geolocationLongitude) {
		this.geolocationLongitude = geolocationLongitude;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", emailAddress="
				+ emailAddress + ", image=" + image + ", category=" + category + ", address=" + address
				+ ", geolocationLatitude=" + geolocationLatitude + ", geolocationLongitude=" + geolocationLongitude
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(id, other.id);
	}

}
