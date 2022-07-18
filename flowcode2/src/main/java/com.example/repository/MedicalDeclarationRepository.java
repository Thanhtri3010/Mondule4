package com.example.repository;

import com.example.model.MedicalDeclaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    private static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();

    static {
        medicalDeclarationList.add(new MedicalDeclaration(1, "Tri", "1997", "Oto", "12", "14", "no"));
        medicalDeclarationList.add(new MedicalDeclaration(2, "Tri", "1997", "Oto", "12", "14", "no"));
        medicalDeclarationList.add(new MedicalDeclaration(3, "Tri", "1997", "Oto", "12", "14", "no"));
    }


    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationList;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findByID(int id) {
        MedicalDeclaration medicalDeclaration = null;
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getId() == id) {
                medicalDeclaration = new MedicalDeclaration(item.getId(), item.getName(), item.getYearOfBirth(), item.getTravelInformation(), item.getStarDay(), item.getEndDay(), item.getNote());
            }
        }
        return medicalDeclaration;
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getId() == id) {
                item.setName(medicalDeclaration.getName());
                item.setYearOfBirth(medicalDeclaration.getYearOfBirth());
                item.setTravelInformation(medicalDeclaration.getTravelInformation());
                item.setStarDay(medicalDeclaration.getStarDay());
                item.setEndDay(medicalDeclaration.getEndDay());
                item.setNote(medicalDeclaration.getNote());
            }
        }
    }

    @Override
    public String[] getYearOfBirth() {
        String[] yearOfBirth = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999"};
        return yearOfBirth;
    }

    @Override
    public String[] getTravelInformation() {
        String[] travelInformation = {"Tàu Bay", "Thuyền", "Ô tô", "Khác"};
        return travelInformation;
    }

    @Override
    public String[] getDay() {
       String[] day  = {"1","2","3"};
       return day;
    }
}
