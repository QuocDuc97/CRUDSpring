package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);


    //default cac phuong thuc implement PresonDao co the implement addPerson hoac k
    default int addPerson(Person person) {
        UUID id= UUID.randomUUID();
        return insertPerson(id, person);
    }

    //get all person
    List<Person> selectAllPerson();

    //get person by id
    Optional <Person> selectPersonById(UUID id);
    //delete person by id
    int deletePersonById(UUID id);
    //update person by id
    int updatePersonById(UUID id, Person person);


}
