package com.example.repository;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {  List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration medicalDeclaration);

    MedicalDeclaration findByID(int id);

    void update(int id, MedicalDeclaration medicalDeclaration);

    String[] getYearOfBirth();

    String[] getTravelInformation();

    String[] getDay();
}
