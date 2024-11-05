package com.spring.todo_management.service;

import com.spring.todo_management.dto.LoginDto;
import com.spring.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
