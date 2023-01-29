package com.dive.graphql.dto;

import lombok.Data;

@Data
public class AddUserRequest {

    private String username;
    private String email;
    private String password;

}
