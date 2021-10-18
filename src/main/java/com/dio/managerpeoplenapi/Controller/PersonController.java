package com.dio.managerpeoplenapi.Controller;

import com.dio.managerpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managerpeoplenapi.entity.Person;
import com.dio.managerpeoplenapi.service.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;



    public PersonController(PersonService personService) {
		this.personService = personService;
	}



	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
       return personService.createPerson(person);
    }
    
}
