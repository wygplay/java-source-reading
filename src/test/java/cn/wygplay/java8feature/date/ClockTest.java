package cn.wygplay.java8feature.date;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Clock api
 * @author wyg
 * @date 2022/6/24 1:22
 */
public class ClockTest {
    @Test
    public void test() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
    }
}
