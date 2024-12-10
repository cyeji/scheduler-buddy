package com.innercircle.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScheduledTask {

    /**
     * 크론탭
     *
     * @return
     */
    String cron() default "";

    /**
     * scheduler 명
     *
     * @return
     */
    String name() default "";

    /**
     * 반복 주기 설정 TimeUnit
     *
     * @return
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

    /**
     * 동시성 처리를 위한 설정
     *
     * @return
     */
    boolean lock() default false;

}
