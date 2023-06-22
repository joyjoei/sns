package com.example.fastcampusmysql.domain.follow.service;

import com.example.fastcampusmysql.application.usacase.CreateFollowMemberUsacase;
import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@RequiredArgsConstructor
@Service
public class FollowWriteService {
    final private FollowRepository followRepository;

    public void create(MemberDto fromMember, MemberDto toMember){/*
        * from, to 회원정보 => 존재하는 회원인지 validation
        * 고민 : 서로 다른 도메인의 데이터를 주고 받을 때
           => application layer 둠
        */
        Assert.isTrue(!fromMember.id().equals(toMember.id()), "from과 id가 동일하다.");

        var follow = Follow.builder()
                        .fromMemberId(fromMember.id())
                        .toMemberId(toMember.id())
                        .build();
        followRepository.save(follow);
    }
}
