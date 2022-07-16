package com.example.service;

import com.example.modle.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();

    Person findByIdCard(String idCard);

    void save(Person person);

    void update(String idCard, Person person);

    String[] getYearOfBirth();

    String[] getGender();

    String[] getNationality();

    String[] getTravelInformation();

    String[] getDay();

    String[] getMonth();

    String[] getYear();

    String[] getProvince();

    String[] getDistrict();

    String[] getWards();

}
