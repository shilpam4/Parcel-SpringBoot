package com.example.parcel.api.controllers;

import com.example.parcel.entities.Address;
import com.example.parcel.entities.Parcel;
import com.example.parcel.entities.Telephone;
import com.example.parcel.exception.ParcelException;
import com.example.parcel.service.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/parcel")
@Slf4j
public class ParcelController {

	private final ParcelService parcelService;

	@Autowired
	public ParcelController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}

	@GetMapping("/parcels")
	public ResponseEntity<List<Parcel>> getAllparcels() {
		return ResponseEntity.ok().body(this.parcelService.getAllParcels());
	}

	@GetMapping("/parcels/{parcelId}")
	public ResponseEntity<Parcel> getParcelById(@PathVariable int parcelId) throws Exception {
		Parcel Parcel = this.parcelService.getParcelById(parcelId);
		if (Parcel == null)
			throw new ParcelException("Parcel doesn't exist");
		return new ResponseEntity<Parcel>(Parcel, HttpStatus.OK);
	}

	@GetMapping("/parcels/name/{name}")
	public ResponseEntity<List<Parcel>> getParcelByName(@PathVariable String name) throws Exception {
		List<Parcel> parcels = this.parcelService.getParcelByName(name);
		if (parcels.isEmpty())
			throw new ParcelException("MATCH_NOT_FOUND");
		return ResponseEntity.ok().body(parcels);
	}

	@PostMapping("/saveParcel")
	public ResponseEntity<String> createParcel(@RequestBody Parcel parcel) {
		return ResponseEntity.ok().body(this.parcelService.createParcel(parcel));
	}

	@PostMapping("/{parcelId}/saveaddress")
	public ResponseEntity<String> createAddress(@RequestBody Address address, @PathVariable int parcelId) {
		return ResponseEntity.ok().body(this.parcelService.createAddress(address, parcelId));
	}

	@PostMapping("/{parcelId}/savetelephone")
	public ResponseEntity<String> createTelephone(@RequestBody Telephone telephone, @PathVariable int parcelId) {
		return ResponseEntity.ok().body(this.parcelService.createTelephone(telephone, parcelId));
	}

	@PutMapping("/updateaddress/{parcelId}/{addressId}")
	public ResponseEntity<String> updateAddress(@PathVariable int parcelId, @PathVariable int addressId,
			@RequestBody Address address) {
		return ResponseEntity.ok().body(this.parcelService.updateAddress(address, parcelId, addressId));
	}
//
//	@PutMapping("/updateParcel/{parcelId}")
//	public ResponseEntity<String> updateParcel(@PathVariable int parcelId, @RequestBody Parcel parcel) {
//		return ResponseEntity.ok().body(this.parcelService.updateParcel(parcelId, parcel));
//	}
//	
	@PutMapping("/updatetelephone/{parcelId}/{telephoneId}")
	public ResponseEntity<String> updateTelephone(@PathVariable int parcelId, @PathVariable int telephoneId,
			@RequestBody Telephone telephone) {
		return ResponseEntity.ok().body(this.parcelService.updateTelephone(telephone, parcelId, telephoneId));
	}

	@DeleteMapping("/deleteParcel/{parcelId}")
	public ResponseEntity<String> deleteParcel(@PathVariable int parcelId) {
		return ResponseEntity.ok().body(this.parcelService.deleteParcel(parcelId));
	}

	@DeleteMapping("/deleteaddress/{parcelId}/{addressId}")
	public ResponseEntity<String> deleteAddress(@PathVariable int parcelId, @PathVariable int addressId) {
		return ResponseEntity.ok().body(this.parcelService.deleteAddress(parcelId, addressId));
	}

	@DeleteMapping("/deletetelephone/{parcelId}/{telephoneId}")
	public ResponseEntity<String> deleteTelephone(@PathVariable int parcelId, @PathVariable int telephoneId) {
		return ResponseEntity.ok().body(this.parcelService.deleteTelephone(parcelId, telephoneId));
	}
}
