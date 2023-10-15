package com.example.springrestdocsproject.member;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberModificationRequest {

    @NotEmpty
    private String name;

}
