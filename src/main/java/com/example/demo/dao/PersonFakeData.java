package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresql")
public class PersonFakeData implements PersonDao {

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonFakeData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    //get list person from db
    @Override
    public List<Person> selectAllPerson() {
        final String sql = "Select id, name from person";
        List<Person> personList = jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        }));
        return personList;

    }

    @Override
    public Optional<Person> selectPersonById(UUID id, String name) {

        final String sql = "select id, name from person where id=? and name=?";
        try {
            Person person = jdbcTemplate.queryForObject(sql, new Object[]{id, name}, ((resultSet, i) -> {
                UUID personId = UUID.fromString(resultSet.getString("id"));
                String personName = resultSet.getString("name");
                return new Person(personId, personName);
            }));
            return Optional.ofNullable(person);

        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            System.out.println("khong tim thay");
            return Optional.empty();

        }
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
