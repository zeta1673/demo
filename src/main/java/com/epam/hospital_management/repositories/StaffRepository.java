package com.epam.hospital_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hospital_management.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {

}
