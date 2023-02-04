package com.dive.graphql.controller.graphql;

import com.dive.graphql.entity.Entity;
import com.dive.graphql.entity.EntityType;
import com.dive.graphql.repository.PostRepository;
import com.dive.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EntityGqlController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @QueryMapping("getEntityById")
    public Optional<Entity> getEntityById(@Argument("entityType") EntityType entityType, @Argument("id") Integer id) {
        final var entity = switch (entityType) {
            case POST -> postRepository.findById(id);
            case USER -> userRepository.findById(id);
        };
        return entity.map(value -> (Entity) value);
    }


}
