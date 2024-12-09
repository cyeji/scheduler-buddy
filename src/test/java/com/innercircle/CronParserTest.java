package com.innercircle;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * con-utils 테스트 코드 작성
 */
class CronParserTest {
    
    @Test
    @DisplayName("cron parser 테스트")
    void test_case_1 () {
        // given
        String validCron = "0 0/5 * * * ?";
        // when
        CronParser parser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));
        // then
        Cron cron = parser.parse(validCron);
        Assertions.assertDoesNotThrow(cron::validate, "Cron expression should be valid");
    }


    @Test
    @DisplayName("cron parser exception 테스트")
    void test_case_2 () {
        String invalidQuartzCron = "invalid cron";
        CronParser parser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));

        assertThrows(IllegalArgumentException.class, () -> {
            Cron cron = parser.parse(invalidQuartzCron);
            cron.validate();
        }, "Invalid cron expression should throw an exception");
    }
}
