package com.example.parcel.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.NoArgsConstructor;

@Entity
@Table(name = "Parcel")
//@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parcel {

	@Id
	@Column(name = "parcel_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parcel_id;

	@Column(name = "Parcel_name")
	private String parcelName;

	@Column(name = "ordered_Dtm")
	@Temporal(TemporalType.DATE)
	private Date orderedDtm;;

	@Column(name = "aadhar_Of_User")
	private String aadharOfUser;

	@Column(name = "last_modified_dtm")
	@UpdateTimestamp
	private Timestamp last_modified_dtm;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parcel_id", referencedColumnName = "parcel_id")
	private List<Address> addresses;

	@OneToMany(targetEntity = Telephone.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parcel_id", referencedColumnName = "parcel_id")
	private List<Telephone> telephones;

	public Parcel() {
	}

	@JsonManagedReference
	public List<Address> getAddresses() {
		return addresses;
	}

	@JsonManagedReference
	public List<Telephone> getTelephones() {
		return telephones;
	}

	public int getParcelId() {
		return parcel_id;
	}

	public void setParcelId(int parcel_id) {
		this.parcel_id = parcel_id;
	}

//	public int getParcel_id() {
//		return parcel_id;
//	}
//	public void setParcel_id(int parcel_id) {
//		this.parcel_id = parcel_id;
//	}
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

	public Timestamp getLast_modified_dtm() {
		return last_modified_dtm;
	}

	public void setLast_modified_dtm(Timestamp last_modified_dtm) {
		this.last_modified_dtm = last_modified_dtm;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
}
