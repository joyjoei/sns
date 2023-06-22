package com.example.fastcampusmysql.application.usacase;

import com.example.fastcampusmysql.domain.follow.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CreateFollowMemberUsacase {

    final private MemberReadService memberReadService;
    final private FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId){
        /*
        * 1. 입력받은 memberId 로 회원 조회
        * 2. FollowWriteService.create()
        * */
        var fromMember = memberReadService.getMember(fromMemberId);
        var toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);
    }
}
