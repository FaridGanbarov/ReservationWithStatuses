package practice.asanxidmet.service;

import practice.asanxidmet.dto.request.UserRequest;
import practice.asanxidmet.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUserById(Long id);
    void delete(String email);
}
