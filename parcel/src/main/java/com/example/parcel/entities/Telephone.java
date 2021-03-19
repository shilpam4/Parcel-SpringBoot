package com.example.parcel.entities;

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
public class Telephone {

	@Id
	@Column(name = "telephone_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int telephone_id;

	private String country_code;

	private String area_code;

	private String cntrl_number;

	private String unique_number;

	@Column(name = "last_modified_dtm")
	@UpdateTimestamp
	private Timestamp last_modified_dtm;

	public Telephone() {
		super();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parcel_id")
	private Parcel parcel;

	@JsonBackReference
	public Parcel getParcel() {
		return parcel;
	}

	public int getTelephoneId() {
		return telephone_id;
	}

	public void setTelephoneId(int telephoneId) {
		this.telephone_id = telephoneId;
	}
//	public int getTelephone_id() {
//		return telephone_id;
//	}
//
//	public void setTelephone_id(int telephone_id) {
//		this.telephone_id = telephone_id;
//	}

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