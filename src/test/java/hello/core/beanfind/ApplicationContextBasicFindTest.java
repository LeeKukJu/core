package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        Object memberService = ac.getBean("memberService", MemberService.class); // 빈 이름으로 빈 객체(인스턴스)를 조회
        assertThat(memberService).isInstanceOf(MemberService.class); // memberService가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        Object memberService = ac.getBean(MemberService.class); // 빈 이름으로 빈 객체(인스턴스)를 조회
        assertThat(memberService).isInstanceOf(MemberService.class); // memberService가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); // 빈 이름으로 빈 객체(인스턴스)를 조회
        assertThat(memberService).isInstanceOf(MemberService.class); // memberService가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        // ac.getBean("xxxxx", MemberService.class); // 빈 이름으로 빈 객체(인스턴스)를 조회
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class)); // 빈 이름으로 빈 객체(인스턴스)를 조회
    }
}
