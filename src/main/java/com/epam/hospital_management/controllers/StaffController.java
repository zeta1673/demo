package com.epam.hospital_management.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.services.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/{id}")
    private Optional<Staff> findById(@PathVariable Long id) {
        return staffService.findById(id);
    }

    @GetMapping()
    private List<Staff> findAll(@RequestParam Optional<Integer> pageNumber,
            @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Direction> order) {

        return staffService
                .findAll(PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5), order.orElse(Direction.ASC),
                        sortBy.orElse("id")));
    }

    @PostMapping()
    private Staff staffMember(@Valid @RequestBody Staff staffMember) {
        return staffService.create(staffMember);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            staffService.findById(id);
            staffService.deleteById(id);
            return new ResponseEntity<>("staff member deleted", HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("error deleting the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
