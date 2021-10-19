package com.dio.managerpeoplenapi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dio.managerpeoplenapi.dto.request.PersonDTO;
import com.dio.managerpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managerpeoplenapi.entity.Person;
import com.dio.managerpeoplenapi.mapper.PersonMapper;
import com.dio.managerpeoplenapi.repository.PersonRepository;

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

    

    
}
