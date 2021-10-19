package com.dio.managerpeoplenapi.mapper;

import com.dio.managerpeoplenapi.dto.request.PersonDTO;
import com.dio.managerpeoplenapi.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PersonMapper {
    
    public static PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-mm-yyyy")
    public abstract Person toModel(PersonDTO personDTO);

    public abstract PersonDTO toDTO(Person person);
}
