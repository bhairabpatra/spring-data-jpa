package springdatajpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import springdatajpa.dto.UserDto;
import springdatajpa.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto mapToUserDto(User user);
    User mapToUserEntity(UserDto userDto);
}
