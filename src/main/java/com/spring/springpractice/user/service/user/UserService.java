package com.spring.springpractice.user.service.user;

import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.dto.UserDto;
import com.spring.springpractice.user.repository.user.UserRepository;
import com.spring.springpractice.user.repository.user.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private UserRepositoryCustom userRepositoryCustom;

    public UserDto saveUser(UserDto dto) {
        return UserDto.from(
            userRepository.save(User.of(dto.name() , dto.email()))
        );
    }

    public void deleteUser(User dto) {
        if (dto.getId() != null) {
            userRepository.delete(dto);
        }
    }


}
