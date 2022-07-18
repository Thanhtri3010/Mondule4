package com.example.service;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalDeclarationService implements IMedicalDeclarationService{
    @Autowired
    private IMedicalDeclarationRepository iMedicalDeclarationRepository;
    @Override
    public List<MedicalDeclaration> findAll() {
        return iMedicalDeclarationRepository.findAll();
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        iMedicalDeclarationRepository.save(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findByID(int id) {
        return iMedicalDeclarationRepository.findByID(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
iMedicalDeclarationRepository.update(id,medicalDeclaration);
    }

    @Override
    public String[] getYearOfBirth() {
        return iMedicalDeclarationRepository.getYearOfBirth();
    }

    @Override
    public String[] getTravelInformation() {
        return iMedicalDeclarationRepository.getTravelInformation();
    }

    @Override
    public String[] getDay() {
        return iMedicalDeclarationRepository.getDay();
    }
}
