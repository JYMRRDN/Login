package com.jrdn.login.util;

import com.jrdn.login.domain.dto.UserFilterDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;

import static com.jrdn.login.domain.QUser.user;

public class UserFilter {

    public static Predicate getUserFilter(UserFilterDto userDto) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(StringUtils.isNotEmpty(userDto.getName())) {
            predicate.and(user.fullName.containsIgnoreCase(userDto.getName()));
        }
        if(StringUtils.isNotEmpty(userDto.getUsername())) {
            predicate.and(user.username.eq(userDto.getUsername()));
        }
        if(StringUtils.isNotEmpty(userDto.getPassword())) {
            predicate.and(user.password.eq(userDto.getPassword()));
        }
        return predicate;
    }
}
