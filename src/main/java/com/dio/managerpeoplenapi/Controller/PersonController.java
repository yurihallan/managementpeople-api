package com.dio.managerpeoplenapi.Controller;

import javax.validation.Valid;

import com.dio.managerpeoplenapi.dto.request.PersonDTO;
import com.dio.managerpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managerpeoplenapi.service.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping
    public String getTest(){
        return "Works!";
    }


	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
       return personService.createPerson(personDTO);
    }
    
}
