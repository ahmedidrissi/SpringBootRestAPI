package com.example.SpringBootRestAPI.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.SpringBootRestAPI.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();
    
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // @Override
    // public int deletePersonById(UUID id) {
    //     Person person = selectPersonById(id).orElse(null);
    //     if (person == null) {
    //         return 0;
    //     }
    //     DB.remove(person);
    //     return 1;
    // }

    // @Override
    // public int updatePersonById(UUID id, Person person) {
    //     return selectPersonById(id).map(p -> {
    //         int indexOfPersonToUpdate = DB.indexOf(p);
    //         if (indexOfPersonToUpdate >= 0) {
    //             DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
    //             return 1;
    //         }
    //         return 0;
    //     }).orElse(0);
    // }
    
}
