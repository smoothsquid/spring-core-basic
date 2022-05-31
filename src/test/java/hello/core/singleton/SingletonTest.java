package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링을 사용하지 않는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 호출할 때 마다 다른 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 참조 값이 다름을 확인
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용한 객체 사용")
    void singletonServiceTest() {

        // 컴파일 에러
        //  new SingletonService();

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // 싱글톤 객체를 호출할 시 항상 같은 객체를 반환
        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤 테스트")
    void springSingletonContainer(){
        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)){

            MemberService memberService1 = ac.getBean(MemberService.class);
            MemberService memberService2 = ac.getBean(MemberService.class);

            System.out.println("memberService1 = " + memberService1);
            System.out.println("memberService2 = " + memberService2);

            assertThat(memberService1).isSameAs(memberService2);
        }
    }

}
