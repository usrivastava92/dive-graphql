package com.dive.graphql.controller.graphql;

import com.dive.graphql.dto.AddUserRequest;
import com.dive.graphql.entity.User;
import com.dive.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserGqlController {

    private final UserRepository userRepository;

    @QueryMapping("users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @QueryMapping("userById")
    public Optional<User> getUserById(@Argument Integer id) {
        return userRepository.findById(id);
    }

    @MutationMapping("addUser")
    public User addUser(@Argument("user") AddUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

}