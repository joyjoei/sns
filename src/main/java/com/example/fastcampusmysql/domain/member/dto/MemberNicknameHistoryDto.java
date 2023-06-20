package com.example.fastcampusmysql.domain.member.dto;

public record MemberNicknameHistoryDto(
        Long id,
        Long memberId,
        String nickname,
        java.time.LocalDateTime createdAt
) {

}
