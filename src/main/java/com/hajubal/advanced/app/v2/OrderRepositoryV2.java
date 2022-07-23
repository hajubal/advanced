package com.hajubal.advanced.app.v2;

import com.hajubal.advanced.trace.TraceId;
import com.hajubal.advanced.trace.TraceStatus;
import com.hajubal.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId, "OrderRepositoryV2.save()");

            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생!");
            }

            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
