package edu.mum.coffee.ViewController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Hatake on 6/21/2017.
 */
@Controller
public class RegistrationViewController {
    @Autowired
    private PersonService personService;

    public RegistrationViewController(PersonService personService){
        this.personService=personService;
    }

    @PostMapping("/registrationForm")
    public String register(@Valid Person person, BindingResult result){
            if(!result.hasErrors()){
                personService.savePerson(person);
                return "redirect:/login";
            }
        return "register";
    }

}
