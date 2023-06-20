package com.example.fastcampusmysql.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {
    static public Member create(){
        //default SEED 생성자
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }
    static public Member create(Long seed){
        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class); //Member 클래스 타입의 객체를 생성하는 코드
    }
}
