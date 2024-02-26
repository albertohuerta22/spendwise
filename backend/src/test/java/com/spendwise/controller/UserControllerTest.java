package com.spendwise.controller;

import com.spendwise.dto.UserDTO;
import com.spendwise.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsers_ShouldReturnUsers() throws Exception {
        UserDTO user1 = new UserDTO(); // Initialize and set properties for user1
        UserDTO user2 = new UserDTO(); // Initialize and set properties for user2
        List<UserDTO> users = Arrays.asList(user1, user2);

        when(userService.findAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));

        verify(userService, times(1)).findAllUsers();
        verifyNoMoreInteractions(userService);
    }
}
