package com.example.member.controller;

import com.example.member.dto.*;
import com.example.member.service.MemberSercvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberSercvice memberSercvice;

    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create(
            @RequestBody MemberCreateRequest request
    ){
        MemberCreateResponse response = memberSercvice.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getAll(
        @RequestBody MemberGetRequest request
    ){
        return ResponseEntity.status(HttpStatus.OK).body(memberSercvice.findAll());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberGetResponse> getOne(
            @PathVariable Long memberId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(memberSercvice.findOne(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateResponse request
    ){
        return ResponseEntity.status(HttpStatus.OK).body(memberSercvice.update(memberId, request));
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(
            @PathVariable Long memberId
    ){
        memberSercvice.delete(memberId);
    }


}
