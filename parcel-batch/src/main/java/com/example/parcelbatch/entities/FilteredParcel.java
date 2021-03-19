package com.example.parcelbatch.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Filtered_Parcel")
public class FilteredParcel {

	@Id
	@Column(name = "unique_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unique_id;

	@Column(name = "Parcel_name")
	private String parcelName;

	@Column(name = "ordered_Dtm")
	@Temporal(TemporalType.DATE)
	private Date orderedDtm;;

	@Column(name = "aadhar_Of_User")
	private String aadharOfUser;

	private String flatno;

	private String street;

	private String city;

	private String state;

	private String country;

	private String country_code;

	private String area_code;

	private String cntrl_number;

	private String unique_number;
//
//	@Column(name = "last_modified_dtm")
//	@UpdateTimestamp
//	private Timestamp last_modified_dtm;

	public FilteredParcel() {
	}

	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}

	public int getUnique_id() {
		return unique_id;
	}

	public FilteredParcel(int unique_id, String parcelName, Date orderedDtm, String aadharOfUser, String flatno,
			String street, String city, String state, String country, String country_code, String area_code,
			String cntrl_number, String unique_number) {
		super();
		this.unique_id = unique_id;
		this.parcelName = parcelName;
		this.orderedDtm = orderedDtm;
		this.aadharOfUser = aadharOfUser;
		this.flatno = flatno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.country_code = country_code;
		this.area_code = area_code;
		this.cntrl_number = cntrl_number;
		this.unique_number = unique_number;
	}

	@Override
	public String toString() {
		return "FilteredParcel [unique_id=" + unique_id + ", parcelName=" + parcelName + ", orderedDtm=" + orderedDtm
				+ ", aadharOfUser=" + aadharOfUser + ", flatno=" + flatno + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", country_code=" + country_code + ", area_code="
				+ area_code + ", cntrl_number=" + cntrl_number + ", unique_number=" + unique_number + "]";
	}

	public String getParcelName() {
		return parcelName;
	}

	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}

	public Date getOrderedDtm() {
		return orderedDtm;
	}

	public void setOrderedDtm(Date orderedDtm) {
		this.orderedDtm = orderedDtm;
	}

	public String getAadharOfUser() {
		return aadharOfUser;
	}

	public void setAadharOfUser(String aadharOfUser) {
		this.aadharOfUser = aadharOfUser;
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

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getCntrl_number() {
		return cntrl_number;
	}

	public void setCntrl_number(String cntrl_number) {
		this.cntrl_number = cntrl_number;
	}

	public String getUnique_number() {
		return unique_number;
	}

	public void setUnique_number(String unique_number) {
		this.unique_number = unique_number;
	}
}
