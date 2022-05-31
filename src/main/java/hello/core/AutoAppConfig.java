package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        관례적으로 Config 클래스를 프로젝트 루트에 위치하고 베이스 패키지 지정하지 않음
//        basePackages = {"hello.core.discount", "hello.core.member"},
//        basePackageClasses = AutoAppConfig.class,
//         AppConfig 스캔 안되게 하기 위하여 @Configuration 어노테이션 예외 처리
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    중복 등록 테스트
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        System.out.println("Bean AutoAppConfig.memberRepository");
//        return new MemoryMemberRepository();
//    }
}
