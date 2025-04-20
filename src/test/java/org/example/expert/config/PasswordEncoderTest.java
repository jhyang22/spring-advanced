package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matches_메서드가_정상적으로_동작한다() {
        // given - 준비
        // 두 매개변수를 임의로 준비함
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        /**
         * 레벨 3-1 테스트 코드 연습 - 1
         */
        // when - 실행
        // given에서 만들어놓은 매개변수를 넣어서 실행
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // then - 결과
        // () 안의 조건이 true라면 test 통과!라는 메서드
        assertTrue(matches);
    }
}
