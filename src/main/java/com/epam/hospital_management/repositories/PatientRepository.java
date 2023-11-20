package com.epam.hospital_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.hospital_management.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT COUNT (DISTINCT hc.id_patient)FROM hospital_card hc WHERE hc.id_staff = :id", nativeQuery = true)
    Long countPatient(@Param("id") Long id);
}
