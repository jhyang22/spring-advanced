package org.example.expert.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        // rawPassword.toCharArray() : 로그인 시 입력한 비밀번호
        // 이 때 toCharArray()를 사용한 이유
        // - String은 불변객체라서 GC가 처리해주기 전까지는 메모리에 남아있을 수 있다
        //      - String s = "hello"; 이후 s = "world"; 라고 수정하면 기존의 문자열은 그대로 있고 s의 참조값이 바뀌는 것!
        // - char[]은 초기화가 가능! 비밀번호 검증 후에 로그인 시 사용한 비밀번호는 초기화하여 흔적을 지워버린다!
        //      - 근데 배열로 만들면 어케 비교하지? 싶었는데 BCrypt라는애가 알아서 비교해주는 듯!
        // BCrypt.verifyer().verify()
        // - rarPassword와 encodedPassword랑 비교해서 BCrypt.Result라는 boolean 값이 나온다
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;
    }
}
