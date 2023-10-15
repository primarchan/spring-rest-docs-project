package com.example.springrestdocsproject;

import com.example.springrestdocsproject.member.Member;
import com.example.springrestdocsproject.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final List<Member> members = new ArrayList<>();
        members.add(new Member("aaa@gmail.com", "aaa"));
        members.add(new Member("bbb@gmail.com", "bbb"));
        members.add(new Member("ccc@gmail.com", "ccc"));
        members.add(new Member("ddd@gmail.com", "ddd"));

        memberRepository.saveAll(members);
    }

}
