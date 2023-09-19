package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * {@link CallLogAspect}에 의해 external, internal 메소드에 대한 프록시가 생성된다.
 */
@Slf4j
@Component
public class CallServiceV0 {

    /**
     * target = CallServiceV0
     * <p>
     * target#external()안에서 target#internal()를 호출할 경우 (내부 호출)
     * target#internal()에 대해 AOP가 적용되지 않아 advice가 호출되지 않는다.
     * <p>
     * 즉,
     * 프록시를 통해 internal을 호출할 경우에만 AOP가 적용된다.
     * target(this) 내에서 internal을 호출한다면 AOP가 적용되지 않는다.
     */
    public void external() {
        log.info("call external");
        internal(); //내부 메서드 호출(this.internal())
    }

    public void internal() {
        log.info("call internal");
    }
}
