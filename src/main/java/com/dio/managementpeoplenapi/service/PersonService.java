package com.dio.managementpeoplenapi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dio.managementpeoplenapi.dto.request.PersonDTO;
import com.dio.managementpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managementpeoplenapi.entity.Person;
import com.dio.managementpeoplenapi.exception.PersonNotFoundException;
import com.dio.managementpeoplenapi.mapper.PersonMapper;
import com.dio.managementpeoplenapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
   
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    


    public MessageResponseDTO createPerson( PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ savePerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
         List<Person> AllPeople = personRepository.findAll();
        return AllPeople.stream()
                    .map(personMapper::toDTO).
                    collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfexist(id);
        return personMapper.toDTO(person);
    }

    public void delete(long id) throws PersonNotFoundException {
        verifyIfexist(id);
    
        personRepository.deleteById(id);        
    }

    

    private Person verifyIfexist(@PathVariable Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }
    
}
