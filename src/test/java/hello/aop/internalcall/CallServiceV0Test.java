package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    /**
     * external 메소드에서만 AOP가 적용되고,
     * external 메소드 내부에서 호출한 internal 메소드에는 AOP가 적용되지 않는다.
     */
    @Test
    void external() {
        callServiceV0.external();
    }

    /**
     * 외부에서 internal 메소드를 호출하면 AOP가 적용된다. 왜냐면 프록시를 거치지 때문이다.
     */
    @Test
    void internal() {
        callServiceV0.internal();
    }
}