package practice.asanxidmet.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import practice.asanxidmet.authentication.dto.request.RegisterRequest;
import practice.asanxidmet.entity.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))")
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target = "id",ignore = true)
    User RegisterDtoToEntity(RegisterRequest request, PasswordEncoder passwordEncoder);
}
