package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import cz.kopecky.pojistovna.data.repositories.UserRepository;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import cz.kopecky.pojistovna.models.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserDTO user)
    {
        UserEntity userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
    }

}
