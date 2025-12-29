package com.example.member.service;

import com.example.member.dto.MemberCreateRequest;
import com.example.member.dto.MemberCreateResponse;
import com.example.member.dto.MemberGetResponse;
import com.example.member.dto.MemberUpdateResponse;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MemberSercvice
{
    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName());

        Member savedMember = memberRepository.save(member);
        return new MemberCreateResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getCreatedAt(),
                savedMember.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<MemberGetResponse> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            MemberGetResponse response = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getCreatedAt(),
                    member.getModifiedAt()
            );
            dtos.add(response);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public MemberGetResponse findOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("없는 멤버")
        );
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getModifiedAt()
                );
    }

    @Transactional
    public MemberUpdateResponse update(Long memberId, MemberUpdateResponse response){
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("없는 멤버")
        );
        member.update(response.getName());
        return new MemberUpdateResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long memberId) {
        boolean exists = memberRepository.existsById(memberId);
        if (!exists) {
            throw new IllegalStateException("없는 멤버 찾지 말아주세여");
        }
        memberRepository.deleteById(memberId);
    }
}
