package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import cz.kopecky.pojistovna.data.repositories.UserRepository;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import cz.kopecky.pojistovna.models.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    /* metoda pro vytvoření uživatele */
    @Override
    public void create(UserDTO user)
    {
        UserEntity userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
    }
    /* metoda pro výpis všech pojištěnců */
    @Override
    public List<UserDTO> getAll()
    {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(i -> userMapper.toDTO(i))
                .toList();
    }
    /* metoda pro zobrazení detailu uživatele */
    @Override
    public UserDTO getById(long userId)
    {
        UserEntity fetchedUser = userRepository
                .findById(userId)
                .orElseThrow();
        return userMapper.toDTO(fetchedUser);
    }

}
