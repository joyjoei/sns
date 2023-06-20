package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class MemberNicknameHistory {
    final private Long id;
    final private Long memberId;
    final private String nickname;
    final private LocalDateTime createdAt;

    //정규화 : 중복을 없애는 것이 핵심이다. 히스토리성 데이터들은 정규화의 대상이 아니다.
    //데이터가 최신성을 가져야하는지, 요구사항을 파내는 노력이 필요

    @Builder
    public MemberNicknameHistory(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);;
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
