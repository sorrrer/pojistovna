package cz.kopecky.pojistovna.models.mappers;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /* převod DTO na entity */
    UserEntity toEntity(UserDTO source);
    /* převod entity na DTO */
    UserDTO toDTO(UserEntity source);
}
