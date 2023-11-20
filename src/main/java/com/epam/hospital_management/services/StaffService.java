package com.epam.hospital_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.repositories.PatientRepository;
import com.epam.hospital_management.repositories.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }

    public List<Staff> findAll(Pageable pageable) {
        List<Staff> list = staffRepository.findAll(pageable).toList();

        list.stream().forEach(staff -> {
            Long count = patientRepository.countPatient(staff.getId());
            staff.setPatientCount(count);
        });

        return list;
    }

    public Staff create(Staff staffMember) {
        return staffRepository.save(staffMember);
    }
}
