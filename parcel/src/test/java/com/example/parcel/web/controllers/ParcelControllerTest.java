package com.example.parcel.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.parcel.api.controllers.ParcelController;
import com.example.parcel.entities.Parcel;
//import com.example.parcel.services.ParcelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ParcelController.class)
@ActiveProfiles("test")
class ParcelControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ParcelService parcelService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private List<Parcel> parcelList;
//
//    @BeforeEach
//    void setUp() {
//        this.parcelList = new ArrayList<>();
//        this.parcelList.add(new Parcel(1L, "text 1"));
//        this.parcelList.add(new Parcel(2L, "text 2"));
//        this.parcelList.add(new Parcel(3L, "text 3"));
//
//        objectMapper.registerModule(new ProblemModule());
//        objectMapper.registerModule(new ConstraintViolationProblemModule());
//    }
//
//    @Test
//    void shouldFetchAllParcels() throws Exception {
//        given(parcelService.findAllParcels()).willReturn(this.parcelList);
//
//        this.mockMvc.perform(get("/Parcels"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(parcelList.size())));
//    }
//
//    @Test
//    void shouldFindParcelById() throws Exception {
//        Long parcelId = 1L;
//        Parcel parcel = new Parcel(parcelId, "text 1");
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.of(parcel));
//
//        this.mockMvc.perform(get("/Parcels/{id}", parcelId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//    }
//
//    @Test
//    void shouldReturn404WhenFetchingNonExistingParcel() throws Exception {
//        Long parcelId = 1L;
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.empty());
//
//        this.mockMvc.perform(get("/Parcels/{id}", parcelId))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    void shouldCreateNewParcel() throws Exception {
//        given(parcelService.saveParcel(any(Parcel.class))).willAnswer((invocation) -> invocation.getArgument(0));
//
//        Parcel parcel = new Parcel(1L, "some text");
//        this.mockMvc.perform(post("/Parcels")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(parcel)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", notNullValue()))
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
//        Long parcelId = 1L;
//        Parcel parcel = new Parcel(parcelId, "Updated text");
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.of(parcel));
//        given(parcelService.saveParcel(any(Parcel.class))).willAnswer((invocation) -> invocation.getArgument(0));
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
//    void shouldReturn404WhenUpdatingNonExistingParcel() throws Exception {
//        Long parcelId = 1L;
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.empty());
//        Parcel parcel = new Parcel(parcelId, "Updated text");
//
//        this.mockMvc.perform(put("/Parcels/{id}", parcelId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(parcel)))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    void shouldDeleteParcel() throws Exception {
//        Long parcelId = 1L;
//        Parcel parcel = new Parcel(parcelId, "Some text");
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.of(parcel));
//        doNothing().when(parcelService).deleteParcelById(parcel.getId());
//
//        this.mockMvc.perform(delete("/Parcels/{id}", parcel.getId()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.text", is(parcel.getText())));
//
//    }
//
//    @Test
//    void shouldReturn404WhenDeletingNonExistingParcel() throws Exception {
//        Long parcelId = 1L;
//        given(parcelService.findParcelById(parcelId)).willReturn(Optional.empty());
//
//        this.mockMvc.perform(delete("/Parcels/{id}", parcelId))
//                .andExpect(status().isNotFound());
//
//    }

}
