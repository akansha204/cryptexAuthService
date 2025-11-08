package com.cryptex.cryptex_authService.service;

import com.cryptex.cryptex_authService.dto.UserDTO;

public interface UserService {
    String registerUser(UserDTO userDTO);
    String loginUser(UserDTO userDTO);
}