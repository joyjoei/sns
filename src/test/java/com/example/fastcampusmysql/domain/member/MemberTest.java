package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest {
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName(){
        /*LongStream.range(0, 10)
                .mapToObj(MemberFixtureFactory::create)
                .forEach(member -> {
                    System.out.println(member.getNickname());
                });*/
        var member = MemberFixtureFactory.create();
        var expectedName = "pnu";

        member.changeNickname(expectedName);

        Assertions.assertEquals(expectedName, member.getNickname());
    }


    @DisplayName("회원 닉네임 10글자 초과 불가.")
    @Test
    public void testNicknameMaxLength(){
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnupnupnupnupnupnup";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNickname(overMaxLengthName)
        );
    }

}
