package com.filipetobias.sbm.services;

import com.filipetobias.sbm.domain.User;
import com.filipetobias.sbm.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User insert(User user);

    void delete(String id);

    User fromDTO(UserDTO userDTO);
}
