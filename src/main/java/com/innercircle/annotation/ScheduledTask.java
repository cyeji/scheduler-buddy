package com.innercircle.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScheduledTask {

    /**
     * 크론탭
     * @return
     */
    String cron() default "";

    /**
     * scheduler 명
     * @return
     */
    String name() default "";

    /**
     * 동시성 처리를 위한 설정
     * @return
     */
    boolean lock() default false;

}
