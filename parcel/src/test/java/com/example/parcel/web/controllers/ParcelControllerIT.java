package com.example.parcel.web.controllers;

import com.example.parcel.common.AbstractIntegrationTest;
import com.example.parcel.entities.Parcel;
import com.example.parcel.repositories.ParcelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ParcelControllerIT extends AbstractIntegrationTest {
//
//    @Autowired
//    private ParcelRepository parcelRepository;
//
//    private List<Parcel> parcelList = null;
//
//    @BeforeEach
//    void setUp() {
//        parcelRepository.deleteAll();
//
//        parcelList = new ArrayList<>();
//        parcelList.add(new Parcel(1L, "First Parcel"));
//        parcelList.add(new Parcel(2L, "Second Parcel"));
//        parcelList.add(new Parcel(3L, "Third Parcel"));
//        parcelList = parcelRepository.saveAll(parcelList);
//    }
//
//    @Test
//    void shouldFetchAllParcels() throws Exception {
//        this.mockMvc.perform(get("/Parcels"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(parcelList.size())));
//    }
//
//    @Test
//    void shouldFindParcelById() throws Exception {
//        Parcel parcel = parcelList.get(0);
//        Long parcelId = parcel.getId();
//
//        this.mockMvc.perform(get("/Parcels/{id}", parcelId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//    }
//
//    @Test
//    void shouldCreateNewParcel() throws Exception {
//        Parcel parcel = new Parcel(null, "New Parcel");
//        this.mockMvc.perform(post("/Parcels")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(parcel)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//
//    }
//
//    @Test
//    void shouldReturn400WhenCreateNewParcelWithoutText() throws Exception {
//        Parcel parcel = new Parcel(null, null);
//
//        this.mockMvc.perform(post("/Parcels")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(parcel)))
//                .andExpect(status().isBadRequest())
//                .andExpect(header().string("Content-Type", is("application/problem+json")))
//                .andExpect(jsonPath("$.type", is("https://zalando.github.io/problem/constraint-violation")))
//                .andExpect(jsonPath("$.title", is("Constraint Violation")))
//                .andExpect(jsonPath("$.status", is(400)))
//                .andExpect(jsonPath("$.violations", hasSize(1)))
//                .andExpect(jsonPath("$.violations[0].field", is("text")))
//                .andExpect(jsonPath("$.violations[0].message", is("Text cannot be empty")))
//                .andReturn();
//    }
//
//    @Test
//    void shouldUpdateParcel() throws Exception {
//        Parcel parcel = parcelList.get(0);
//        parcel.setText("Updated Parcel");
//
//        this.mockMvc.perform(put("/Parcels/{id}", parcel.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(parcel)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//
//    }
//
//    @Test
//    void shouldDeleteParcel() throws Exception {
//        Parcel parcel = parcelList.get(0);
//
//        this.mockMvc.perform(
//                delete("/Parcels/{id}", parcel.getId()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//
//    }

}
