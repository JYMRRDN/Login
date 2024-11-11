package com.jrdn.login.domain.mapper;

import com.jrdn.login.domain.User;
import com.jrdn.login.domain.dto.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDto toDto(User user);

    @Mapping(target = "role",ignore = true)
    User toUser(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateEntity(UserDto userDto, @MappingTarget User user);
}
