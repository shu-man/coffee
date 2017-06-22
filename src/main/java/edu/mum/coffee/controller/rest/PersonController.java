package edu.mum.coffee.controller.rest;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hatake on 6/20/2017.
 */
@RestController
@RequestMapping("/person")

public class PersonController {
    @Resource
    private PersonService personService;

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable("id") long id) {
        return personService.findById(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Person> findByEmail(@RequestParam("email") String email) { // RequestParam is used because email doesnot work on path variable
        return personService.findByEmail(email);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Person person) {
        
        personService.savePerson(person);
    }
}

