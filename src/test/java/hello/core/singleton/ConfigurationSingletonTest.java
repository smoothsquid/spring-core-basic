package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("AppConfig 에 싱글톤이 적용되는지 테스트")
    void configurationSingleton() {
        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)) {
            OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
            MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
            MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

            // 모든 MemberRepository 빈이 같은 인스턴스이다
            System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());
            System.out.println("orderService.getMemberRepository() = " + orderService.getMemberRepository());
            System.out.println("memberRepository = " + memberRepository);

            assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
            assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);

        }

    }
}
