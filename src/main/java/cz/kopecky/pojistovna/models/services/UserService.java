package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.models.dto.UserDTO;

public interface UserService {
    void create(UserDTO user);
}
