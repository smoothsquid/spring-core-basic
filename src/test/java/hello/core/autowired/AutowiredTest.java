package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class)) {
            TestBean testBean = ac.getBean(TestBean.class);
        }
    }

    static class TestBean {

        // 호출되지 않음
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("1. member = " + member);
        }

        // null
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("2. member = " + member);
        }

        // Optional.empty
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("3. member = " + member);
        }

    }
}
