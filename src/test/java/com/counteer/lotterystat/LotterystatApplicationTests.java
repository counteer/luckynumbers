package com.counteer.lotterystat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = {"stat.file.name=otos2.csv", "stat.hot.threshold=3"})
class LotterystatApplicationTests {

    @Autowired
    LuckyNumbers luckyNumbers;

    @Test
    void contextLoads() {
        List<List<Integer>> result = luckyNumbers.forecast();
        List<List<Integer>> expected = List.of(List.of(4, 38, 9, 12, 78));
        assertEquals(result, expected );
    }

}
