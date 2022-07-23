package com.hajubal.advanced.trace.hellotrace;

import com.hajubal.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void begin() {
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();

        TraceStatus traceStatus1 = helloTraceV2.begin("test1");

        TraceStatus traceStatus2 = helloTraceV2.beginSync(traceStatus1.getTraceId(), "test2");

        helloTraceV2.end(traceStatus2);
        helloTraceV2.end(traceStatus1);
    }



    @Test
    void end() {
    }

    @Test
    void exception() {
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        TraceStatus traceStatus1 = helloTraceV2.begin("test1");
        TraceStatus traceStatus2 = helloTraceV2.beginSync(traceStatus1.getTraceId(), "test2");
        helloTraceV2.exception(traceStatus2, new IllegalArgumentException("error2"));
        helloTraceV2.exception(traceStatus1, new IllegalArgumentException("error1"));
    }
}