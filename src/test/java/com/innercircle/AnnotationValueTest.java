package com.innercircle;

import com.innercircle.annotation.ScheduledTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Scheduler 어노테이션 검증 테스트
 * 1. @어노테이션에서 cron 값을 정상적으로 가져왓는지 확인
 */
@Slf4j
class AnnotationValueTest {

    @Test
    @DisplayName("어노테이션 Value 테스트")
    void test_case_1() throws Exception {
        // given
        Class<?> clazz = SchedulerTaskAnnotationTest.class;
        // when
        Method declaredMethods = clazz.getDeclaredMethod("test");
        // then
        if (declaredMethods.isAnnotationPresent(ScheduledTask.class)) {
            ScheduledTask annotation = declaredMethods.getAnnotation(ScheduledTask.class);

            log.info("Found annotation method: {}", declaredMethods.getName());
            log.info("cron:{}", annotation.cron());
            log.info("name:{}", annotation.name());

            assertEquals("schedulerTaskAnnotation", annotation.name());
            assertEquals("0 0/1 * * * ?", annotation.cron());
        }

    }

    static class SchedulerTaskAnnotationTest {

        @ScheduledTask(cron = "0 0/1 * * * ?", name = "schedulerTaskAnnotation")
        public void test() {
            log.info("SchedulerTaskAnnotation");
        }

    }

}
