package com.example.springrestdocsproject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberRepository memberRepository;

    /**
     * 1. Member 단일 조회
     * 2. Member 생성
     * 3. Member 수정
     * 4. Member 페이징 조회
     */

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return new MemberResponse(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found")));
    }

    @PostMapping
    public void createMember(@RequestBody MemberSignUpRequest request) {
        memberRepository.save(request.toEntity());
    }

    @PutMapping("/{id}")
    public void modify(
            @PathVariable Long id,
            @RequestBody @Valid MemberModificationRequest request
    ) {
        final Member member = memberRepository.findById(id).get();
        member.modify(request.getName());
        memberRepository.save(member);
    }

    @GetMapping
    public Page<MemberResponse> getMembers(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable
    ) {
        return memberRepository.findAll(pageable).map(MemberResponse::new);
    }

}
