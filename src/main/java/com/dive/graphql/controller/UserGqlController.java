package com.dive.graphql.controller;

import com.dive.graphql.dto.AddUserRequest;
import com.dive.graphql.entity.User;
import com.dive.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserGqlController {

    private final UserRepository userRepository;
    private final Sinks.Many<User> userSink = Sinks.many()
            .multicast()
            .onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    private final Publisher<User> userPublisher = userSink.asFlux();

    @QueryMapping("allUsers")
    public Iterable<User> allUser() {
        return userRepository.findAll();
    }

    @MutationMapping("addUser")
    public User addUser(@Argument("user") AddUserRequest addUserRequest) {
        final var user = new User();
        user.setPassword(addUserRequest.getPassword());
        user.setEmail(addUserRequest.getEmail());
        user.setUsername(addUserRequest.getUsername());
        final var dbUser = userRepository.save(user);
        userSink.tryEmitNext(dbUser);
        return dbUser;
    }

    @SubscriptionMapping("onUserCreation")
    public Publisher<User> onUserCreation() {
        return userPublisher;
    }

}
