package com.counteer.lotterystat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SumOfDrawTest {

    SumOfDraw underTest = new SumOfDraw();

    @Test
    public void testSumOfDraw() {
        int result = underTest.getMostCommonDrawSum(getMockArchive());
        Assertions.assertEquals(result, 33);
    }

    private List<int[]> getMockArchive(){
        List<int[]> intArrayList = new ArrayList<>();
        intArrayList.add(new int[]{1, 2, 3,4,5});
        intArrayList.add(new int[]{2, 3, 4,5,6});
        intArrayList.add(new int[]{3, 4, 5, 10, 11});
        intArrayList.add(new int[]{4, 5, 6, 7, 11});
        intArrayList.add(new int[]{5, 6, 7, 8, 9});
        return intArrayList;
    }
}