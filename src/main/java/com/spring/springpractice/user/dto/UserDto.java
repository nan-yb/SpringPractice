package com.spring.springpractice.user.dto;

import com.spring.springpractice.user.domain.user.User;

import javax.sound.sampled.AudioFileFormat;
import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String name ,
        String email,
        LocalDateTime rog_date,
        LocalDateTime mod_date
) {

    public static UserDto of (String name , String email ){
        return new UserDto(null , name , email , null , null);
    }

    public static UserDto of (Long id , String name , String email , LocalDateTime rog_date ,LocalDateTime mod_date){
        return new UserDto(id , name , email , rog_date , mod_date);
    }

    public static UserDto from(User entity){
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getRogDate(),
                entity.getModDate()
        );
    }

    public UserDto toEntity(){
        return UserDto.of(
                id ,
                name ,
                email ,
                rog_date,
                mod_date
        );
    }
}
