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

import com.epam.hospital_management.models.HospitalCard;
import com.epam.hospital_management.services.HospitalCardService;

@RestController
@RequestMapping("/card")
public class HospitalCardController {

    @Autowired
    private HospitalCardService hospitalCardService;

    @GetMapping()
    private Page<HospitalCard> findAll(@RequestParam Optional<Integer> pageNumber,
            @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Direction> order) {

        return hospitalCardService.findAll(PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5),
                order.orElse(Direction.ASC), sortBy.orElse("id")));
    }

    @GetMapping("/{id}")
    private Optional<HospitalCard> findById(@PathVariable Long id) {
        return hospitalCardService.findById(id);
    }

    @PostMapping()
    private HospitalCard create(@RequestBody HospitalCard hospitalCard) {
        return hospitalCardService.create(hospitalCard);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable Long id) {

        try {
            hospitalCardService.findById(id);
            hospitalCardService.deleteById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("error deleting the hospital card", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("hospital card deleted", HttpStatus.OK);
    }
}
