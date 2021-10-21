package com.dio.managerpersonapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.dio.managementpeoplenapi.dto.request.PersonDTO;
import com.dio.managementpeoplenapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Paleta";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2021, 10, 04);
    
    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .cpf(CPF_NUMBER)
                    .birthDate("04-04-2018")
                    .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                    .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                    .id(PERSON_ID)
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .cpf(CPF_NUMBER)
                    .birthDate(BIRTH_DATE)
                    .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                    .build();
    }
}
