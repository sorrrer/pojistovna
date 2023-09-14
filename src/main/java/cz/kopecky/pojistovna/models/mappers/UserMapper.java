package cz.kopecky.pojistovna.models.mappers;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDTO source);
}
