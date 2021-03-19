package com.example.parcelbatch.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Address {

	@Id
	@Column(name = "address_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;

	private String flatno;

	private String street;

	private String city;

	private String state;

	private String country;

	@Column(name = "last_modified_dtm")
	@UpdateTimestamp
	private Timestamp last_modified_dtm;

	public Address() {

	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parcel_id")
	private Parcel parcel;

	@JsonBackReference
	public Parcel getParcel() {
		return parcel;
	}

	public int getAddressId() {
		return address_id;
	}

	public void setAddressId(int addressId) {
		this.address_id = addressId;
	}

	public String getFlatno() {
		return flatno;
	}

	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLast_modified_dtm() {
		return last_modified_dtm;
	}

	public void setLast_modified_dtm(Timestamp last_modified_dtm) {
		this.last_modified_dtm = last_modified_dtm;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

}
