package com.spendwise.service;

import com.spendwise.entity.User;
import com.spendwise.dto.UserDTO;
import com.spendwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getUser_id());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

   
}
