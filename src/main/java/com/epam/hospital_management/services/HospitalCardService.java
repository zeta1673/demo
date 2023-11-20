package com.epam.hospital_management.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.HospitalCard;
import com.epam.hospital_management.repositories.HospitalCardRepository;

@Service
public class HospitalCardService {

    @Autowired
    private HospitalCardRepository hospitalCardRepository;

    public Page<HospitalCard> findAll(Pageable pageable) {
        return hospitalCardRepository.findAll(pageable);
    }

    public Optional<HospitalCard> findById(Long id) {
        return hospitalCardRepository.findById(id);
    }

    public HospitalCard create(HospitalCard hospitalCard) {
        return hospitalCardRepository.save(hospitalCard);
    }

    public void deleteById(Long id) {
        hospitalCardRepository.deleteById(id);
    }
}
