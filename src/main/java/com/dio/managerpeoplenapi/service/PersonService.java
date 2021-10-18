package com.dio.managerpeoplenapi.service;

import com.dio.managerpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managerpeoplenapi.entity.Person;
import com.dio.managerpeoplenapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
   
    private PersonRepository personRepository;

    @Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    public MessageResponseDTO createPerson( Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ savePerson.getId())
                .build();
    }
    

    
}
