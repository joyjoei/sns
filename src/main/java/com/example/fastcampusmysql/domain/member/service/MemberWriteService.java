package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MemberWriteService {
    /*
       목표 : 회원정보(이메일, 닉네임, 생년월일)을 등록한다.
             닉네임은 10자를 넘길 수 없다.
       파라미터 - memberRegisterCommand
       var member = Member.of(memberRegisterCommand)    //회원 객체
       memberRepository.save(member) //회원 객체 받아서 저장하기
    */
    final private MemberRepository memberRepository;
    final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public Member register(RegisterMemberCommand command){
        var member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthday())
                .build();       // build() 가 객체를 생성해 돌려준다.

        var savedMember = memberRepository.save(member);
        saveMemberNicknameHistory(savedMember);
        return savedMember;
    }

    public void changeNickname(Long memberId, String nickname){
  /*
    1. 회원의 nickname을 변경한다.
    2. 변경내역을 저장한다.
  */
    //nickname 변경한다.
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);
        //변경내역 히스토리를 저장한다.
        saveMemberNicknameHistory(member);

    }
    private void saveMemberNicknameHistory(Member member){
        var history = MemberNicknameHistory
                .builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();

        memberNicknameHistoryRepository.save(history);
    }

}
