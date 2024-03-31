package dev.cats.cookapp.services.user;

import dev.cats.cookapp.dto.response.UserResponse;
import dev.cats.cookapp.mappers.UserMapper;
import dev.cats.cookapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<UserResponse> getUser(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public Optional<UserResponse> getUser(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDto);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
