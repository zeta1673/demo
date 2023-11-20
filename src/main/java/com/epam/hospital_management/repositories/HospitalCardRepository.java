package com.epam.hospital_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hospital_management.models.HospitalCard;

public interface HospitalCardRepository extends JpaRepository<HospitalCard, Long> {

}
