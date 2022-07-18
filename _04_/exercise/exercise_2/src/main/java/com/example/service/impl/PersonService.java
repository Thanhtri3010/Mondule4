package com.example.service.impl;

import com.example.modle.Person;
import com.example.repository.IPersonRepository;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByIdCard(String idCard) {
        return personRepository.findByIdCard(idCard);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(String idCard, Person person) {

    }

    @Override
    public String[] getYearOfBirth() {
        return personRepository.getYearOfBirth();
    }

    @Override
    public String[] getGender() {
        return personRepository.getGender();
    }

    @Override
    public String[] getNationality() {
        return personRepository.getNationality();
    }

    @Override
    public String[] getTravelInformation() {
        return personRepository.getTravelInformation();
    }

    @Override
    public String[] getDay() {
        return personRepository.getDay();
    }

    @Override
    public String[] getMonth() {
        return personRepository.getMonth();
    }

    @Override
    public String[] getYear() {
        return personRepository.getYear();
    }

    @Override
    public String[] getProvince() {
        return personRepository.getProvince();
    }

    @Override
    public String[] getDistrict() {
        return personRepository.getDistrict();
    }

    @Override
    public String[] getWards() {
        return personRepository.getWards();
    }
}
