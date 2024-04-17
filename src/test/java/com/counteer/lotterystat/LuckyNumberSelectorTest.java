package com.counteer.lotterystat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuckyNumberSelectorTest {

    @Test
    public void test1() {
        LuckyNumberSelector selector = new LuckyNumberSelector();
        List<Integer> inputList = List.of(1, 2, 10, 11, 12, 15, 88, 90);
        List<List<Integer>> result = selector.findCombinations(inputList, 22, 3);
        List<List<Integer>> expected = List.of(List.of(1, 10, 11));
        assertEquals(expected, result);
    }
}
