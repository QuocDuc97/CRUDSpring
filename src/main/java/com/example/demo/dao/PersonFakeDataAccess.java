package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonFakeDataAccess implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getFullname()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id, String name) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                ;
    }

    @Override
    public int deletePersonById(UUID id) {
//        //check person exists or not exists
//        Optional<Person> personMaybe= selectPersonById(id);
//        if (personMaybe.isEmpty()) {
//            return 0;
//        }
//        DB.remove(personMaybe.get());
        return 1;
    }

    //hello
    @Override
    public int updatePersonById(UUID id, Person personUpdate) {
        //check person exists or not exists
//        return selectPersonById(id).map(person -> {
//            int indexOfPersonSelect = DB.indexOf(person);
//            if (indexOfPersonSelect >= 0) {
//                DB.set(indexOfPersonSelect, new Person(id, personUpdate.getFullname()));
//                return 1;
//            }
//            return 0;
//        }).orElse(0);
        return 0;

    }
}
