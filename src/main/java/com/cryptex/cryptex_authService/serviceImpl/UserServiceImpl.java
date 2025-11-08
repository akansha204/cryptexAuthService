package com.cryptex.cryptex_authService.serviceImpl;

import com.cryptex.cryptex_authService.dto.UserDTO;
import com.cryptex.cryptex_authService.enitity.UserEnitity;
import com.cryptex.cryptex_authService.repo.UserRepo;
import com.cryptex.cryptex_authService.service.UserService;
import com.cryptex.cryptex_authService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String registerUser(UserDTO userDTO){
        Optional<UserEnitity> existingUser = repo.findByEmail(userDTO.getEmail());
        if(existingUser.isPresent()){
            return "User already exists!";
        }

        UserEnitity user = new UserEnitity();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        repo.save(user);
        return "User registered successfully!";
    }
    @Override
    public String loginUser(UserDTO userDTO){
        Optional<UserEnitity> user = repo.findByEmail(userDTO.getEmail());
        if(user.isEmpty()){
            return "User not found";
        }
        if(!passwordEncoder.matches(userDTO.getPassword(),user.get().getPassword())){
            return "Invalid Password";
        }

        String token = jwtUtil.generateToken(userDTO.getEmail());

        return token;
    }
}
