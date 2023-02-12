package com.dive.graphql.controller;

import com.dive.graphql.entity.Post;
import com.dive.graphql.entity.User;
import com.dive.graphql.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostGqlController {

    private final PostRepository postRepository;

    @QueryMapping("allPosts")
    public Iterable<Post> allUser() {
        return postRepository.findAll();
    }

}
