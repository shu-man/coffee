package edu.mum.coffee.service;

import edu.mum.coffee.domain.Authority;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        Authority authority = new Authority(person, "USER");
        person.setAuthorities(Collections.singletonList(authority));
        return personRepository.save(person);
    }

    public Person saveP(Person person){
        return personRepository.save(person);
    }

    public List<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person findById(Long id) {
        return personRepository.findOne(id);
    }

    public void removePerson(Person person) {
        personRepository.delete(person);
    }

    public List<Person> findAll(){return personRepository.findAll();}

    public Person update(Person person){
        person.setAuthorities(personRepository.findOne(person.getId()).getAuthorities());
        return personRepository.save(person);}

}
