package com.dio.managementpeoplenapi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dio.managementpeoplenapi.dto.request.PersonDTO;
import com.dio.managementpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managementpeoplenapi.entity.Person;
import com.dio.managementpeoplenapi.mapper.PersonMapper;
import com.dio.managementpeoplenapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
   
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    

    @Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

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
        Person person = personRepository.findById(id)
                .orElseThrow(()->  new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    

    
}
