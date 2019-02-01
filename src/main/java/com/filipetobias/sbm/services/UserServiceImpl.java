package com.filipetobias.sbm.services;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.domain.User;
import com.filipetobias.sbm.dto.UserDTO;
import com.filipetobias.sbm.repository.UserRepository;
import com.filipetobias.sbm.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public User insert(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User update(User updateUser) {
        User exist = findById(updateUser.getId());
        updateData(exist, updateUser);
        return userRepository.save(exist);
    }

    @Override
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User exist, User updateUser) {
        exist.setName(updateUser.getName());
        exist.setEmail(updateUser.getEmail());
    }
}
