package cn.wygplay.java8feature.date;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author wyg
 * @date 2022/6/25 10:59
 */
public class TimeZoneTest {
    @Test
    public void testTimeZone() {
        System.out.println(ZoneId.getAvailableZoneIds());

       assertThrows(UnsupportedOperationException.class, () -> ZoneId.SHORT_IDS.put("ACT", ""));
    }
}
