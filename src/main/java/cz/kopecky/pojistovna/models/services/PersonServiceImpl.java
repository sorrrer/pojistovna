package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.data.entities.PersonEntity;
import cz.kopecky.pojistovna.data.repositories.PersonRepository;
import cz.kopecky.pojistovna.models.dto.PersonDTO;
import cz.kopecky.pojistovna.models.exceptions.DuplicateEmailException;
import cz.kopecky.pojistovna.models.exceptions.PasswordDoNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void create(PersonDTO person, boolean isAdmin)
    {
        if(!person.getPassword().equals(person.getConfirmPassword()))
            throw new PasswordDoNotException();

        PersonEntity personEntity = new PersonEntity();

        personEntity.setEmail(person.getEmail());
        personEntity.setPassword(passwordEncoder.encode(person.getPassword()));
        personEntity.setAdmin(isAdmin);
        try {
            personRepository.save(personEntity);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DuplicateEmailException();
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException
    {
        return personRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("username, " + username + " not found."));
    }
}
