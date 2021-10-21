package com.dio.managementpeoplenapi.Controller;

import java.util.List;

import javax.validation.Valid;

import com.dio.managementpeoplenapi.dto.request.PersonDTO;
import com.dio.managementpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managementpeoplenapi.exception.PersonNotFoundException;
import com.dio.managementpeoplenapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;



    @GetMapping
    public List<PersonDTO> ListAll(){
        return personService.listAll();
    }


	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
       return personService.createPerson(personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }
    

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody  @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateById(id, personDTO);

    }
}
