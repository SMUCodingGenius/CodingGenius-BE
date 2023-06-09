package com.codingGenius.coding_genius.service;

import com.codingGenius.coding_genius.dto.UserResponseDto;

public interface UserService {
    public UserResponseDto getUserInfo(String token);

    public String getUserName(String token);

    public void deleteUser(String email);

    public void changePassword(String email, String password);
}
