package com.example.fastcampusmysql.domain.follow.entity;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Follow {
    final private Long id;


    final private String fromMemberId;

    final private String toMemberId;

    final private LocalDateTime createdAt;

    @Builder
    public Follow(Long id, String fromMemberId, String toMemberId, LocalDateTime createdAt) {
        this.id = id;
        this.fromMemberId = fromMemberId;
        this.toMemberId = toMemberId;
        this.createdAt = createdAt;
    }




}
