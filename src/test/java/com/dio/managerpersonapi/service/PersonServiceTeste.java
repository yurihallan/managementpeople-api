package com.dio.managerpersonapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.dio.managementpeoplenapi.dto.request.PersonDTO;
import com.dio.managementpeoplenapi.dto.response.MessageResponseDTO;
import com.dio.managementpeoplenapi.entity.Person;
import com.dio.managementpeoplenapi.repository.PersonRepository;
import com.dio.managementpeoplenapi.service.PersonService;
import com.dio.managerpersonapi.utils.PersonUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTeste {
    
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOthenReturnMessage(){
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage =   MessageResponseDTO
                                                        .builder()
                                                        .message("Create person with success " + expectedSavedPerson.getId())
                                                        .build();

        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }
}
