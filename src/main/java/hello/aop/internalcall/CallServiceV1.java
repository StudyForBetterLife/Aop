package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    /**
     * constructor로 주입하면 circular injection error 발생하므로
     * setter를 통해 주입받도록 해야 한다.
     */
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    /**
     * target#external()에서 this.internal()이 아니라
     * callServiceV1.internal()을 호출한다.
     * <p>
     * 프록시를 통해 호출한 callServiceV1.internal()에 AOP가 적용된다.
     */
    public void external() {
        log.info("call external");
        callServiceV1.internal(); //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
