package com.example.repository.impl;

import com.example.modle.Person;
import com.example.repository.IPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {
    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("Tri", "30/10/1997", "Nam", "Viet Nam", "123", "Tàu Bay", "AB23", "A2", "12", "2", "2020", "13", "2", "2020", "no", "Pleiku", "pleiku", "hoi thuong", "88 Nguyen Thai Hoc"));
        personList.add(new Person("Tri", "30/10/1997", "Nam", "Viet Nam", "234", "Tàu Bay", "AB23", "A2", "12", "2", "2020", "13", "2", "2020", "no", "Pleiku", "pleiku", "hoi thuong", "88 Nguyen Thai Hoc"));
        personList.add(new Person("Tri", "30/10/1997", "Nam", "Viet Nam", "567", "Tàu Bay", "AB23", "A2", "12", "2", "2020", "13", "2", "2020", "no", "Pleiku", "pleiku", "hoi thuong", "88 Nguyen Thai Hoc"));
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public Person findByIdCard(String idCard) {
        Person person = null;
        for (Person item : personList) {
            if (item.getIdCard() == idCard) {
                person = new Person(item.getName(), item.getYearOfBirth(), item.getGender(), item.getNationality(), item.getIdCard(), item.getTravelInformation(), item.getVehicleNumber(), item.getSeats(), item.getStarDay(), item.getStarMonth(), item.getStarYear(), item.getEndDay(), item.getEndMonth(), item.getEndYear(), item.getNote(), item.getProvince(), item.getDistrict(), item.getWards(), item.getAddressOfResidence());
            }
        }
        return person;
    }

    @Override
    public void save(Person person) {
        personList.add(person);
    }

    @Override
    public void update(String idCard, Person person) {
        for (Person item : personList) {
            if (item.getIdCard() == idCard){
                item.setName(person.getName());
                item.setYearOfBirth(person.getYearOfBirth());
                item.setGender(person.getGender());
                item.setNationality(person.getNationality());
                item.setTravelInformation(person.getTravelInformation());
                item.setVehicleNumber(person.getVehicleNumber());
                item.setSeats(person.getSeats());
                item.setStarDay(person.getStarDay());
                item.setStarMonth(person.getStarMonth());
                item.setStarYear(person.getStarYear());
                item.setStarYear(person.getStarYear());
                item.setEndDay(person.getEndDay());
                item.setEndMonth(person.getEndMonth());
                item.setEndYear(person.getEndYear());
                item.setNote(person.getNote());
                item.setProvince(person.getProvince());
                item.setDistrict(person.getDistrict());
                item.setWards(person.getWards());
                item.setAddressOfResidence(person.getAddressOfResidence());
            }
        }
    }

    @Override
    public String[] getYearOfBirth() {
        String[] yearOfBirth = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999"};
        return yearOfBirth;
    }

    @Override
    public String[] getGender() {
        String[] gender = {"Nam", "Nữ", "Khác"};
        return gender;
    }

    @Override
    public String[] getNationality() {
        String[] nationality = {"Việt Nam", "Trung Quốc", "Anh", "Pháp", "Đức"};
        return nationality;
    }

    @Override
    public String[] getTravelInformation() {
        String[] travelInformation = {"Tàu Bay", "Thuyền", "Ô tô", "Khác"};
        return travelInformation;
    }

    @Override
    public String[] getDay() {
        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "3", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31"};
        return day;
    }

    @Override
    public String[] getMonth() {
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return month;
    }

    @Override
    public String[] getYear() {
        String[] year = {"2018", "2019", "2020", "2021", "2022"};
        return year;
    }

    @Override
    public String[] getProvince() {
        String[] province = {"Da Nang", "TPHCM", "Ha Noi", "Pleiku"};
        return province;
    }

    @Override
    public String[] getDistrict() {
        String[] district = {"Hai Chau", "Quan 7", "Hoan Kiem", "Pleiku"};
        return district;
    }

    @Override
    public String[] getWards() {
        String[] wards = {"Thanh Binh", "Tan Phu", "Trang Tien", "Hoi Thuong"};
        return wards;
    }
}
