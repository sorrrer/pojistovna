package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.models.dto.UserDTO;

import java.util.List;

public interface UserService {

    void create(UserDTO user);
    List<UserDTO> getAll();
    UserDTO getById(long userId);
    void edit(UserDTO user);
    void remove(long userId);
}
