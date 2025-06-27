package practice.asanxidmet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import practice.asanxidmet.dto.request.UserRequest;
import practice.asanxidmet.dto.response.UserResponse;
import practice.asanxidmet.service.UserService;

import java.util.List;

@RequestMapping("/api/v1/user/")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/allUsers")
    public List<UserResponse> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        final var updatedUser = service.updateUser(id, userRequest);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(updatedUser.getId());
        return ResponseEntity.created(location).body(updatedUser);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        service.delete(email);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
