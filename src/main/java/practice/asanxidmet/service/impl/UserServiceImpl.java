package practice.asanxidmet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.asanxidmet.dto.request.UserRequest;
import practice.asanxidmet.dto.response.UserResponse;
import practice.asanxidmet.entity.User;
import practice.asanxidmet.enums.Exceptions;
import practice.asanxidmet.exception.ApplicationException;
import practice.asanxidmet.mapper.UserMapper;
import practice.asanxidmet.repository.UserRepository;
import practice.asanxidmet.service.UserService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserRepository repository;


    @Override
    public List<UserResponse> getAllUsers() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = repository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND));
        mapper.updateEntityFromDto(request, user);
        user.setUpdatedAt(LocalDateTime.now());
        repository.save(user);
        return mapper.entityToDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND));
        repository.deleteById(id);
    }

    @Override
    public void delete(String email) {
        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty()) {
            throw new ApplicationException(Exceptions.USER_NOT_FOUND);
        }
        repository.delete(user.get());
    }
}
