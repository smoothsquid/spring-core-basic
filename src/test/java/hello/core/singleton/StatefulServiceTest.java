package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    @DisplayName("상태를 가지는 싱글톤 문제 발생 테스트")
    void statefulSingletonTest() {
        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class)) {
            StatefulService statefulService1 = ac.getBean(StatefulService.class);
            StatefulService statefulService2 = ac.getBean(StatefulService.class);

            statefulService1.order("orderA", 10000);
            statefulService2.order("orderB", 20000);

            // statefulService1 의 price 필드가 10000이 아니게 됨
            assertThat(statefulService1.getPrice()).isNotEqualTo(10000);
        }
    }

    @Configuration
    static class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }


    }
}