package com.epam.hospital_management.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hospital_management.models.Patient;
import com.epam.hospital_management.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    private Optional<Patient> findById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping()
    private Page<Patient> findAll(@RequestParam Optional<Integer> pageNumber,
            @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Direction> order) {

        return patientService
                .findAll(PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5), order.orElse(Direction.ASC),
                        sortBy.orElse("id")));
    }

    @PostMapping()
    private Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable Long id) {

        try {
            patientService.findById(id);
            patientService.deleteById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("error deleting the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("patient deleted", HttpStatus.OK);

    }
}
