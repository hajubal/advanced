package com.hajubal.advanced.trace.hellotrace;

import com.hajubal.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void begin() {
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();

        TraceStatus traceStatus = helloTraceV1.begin("test");

        helloTraceV1.end(traceStatus);
    }



    @Test
    void end() {
    }

    @Test
    void exception() {
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        TraceStatus test = helloTraceV1.begin("test");
        helloTraceV1.exception(test, new IllegalArgumentException("error"));
    }
}