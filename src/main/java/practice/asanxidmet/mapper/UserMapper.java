package practice.asanxidmet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import practice.asanxidmet.dto.request.UserRequest;
import practice.asanxidmet.dto.response.UserResponse;
import practice.asanxidmet.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserResponse> entityListToDtoList(List<User> usersList);
    UserResponse entityToDto(User user);
    User dtoToEntity(UserRequest userRequest);
    User updateEntityFromDto(UserRequest userRequest,@MappingTarget User user);
}
