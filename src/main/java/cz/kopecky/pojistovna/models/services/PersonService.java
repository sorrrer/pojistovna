package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.models.dto.PersonDTO;

public interface PersonService {
    void create(PersonDTO person,boolean isAdmin);

}
