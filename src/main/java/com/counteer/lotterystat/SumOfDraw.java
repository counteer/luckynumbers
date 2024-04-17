package com.counteer.lotterystat;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SumOfDraw {

    public int getMostCommonDrawSum(List<int[]> archive){

        Map<Integer, Long> sumCountMap = archive.stream()
                .mapToInt(array -> Arrays.stream(array).sum())
                .boxed()
                .collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                ));
        return Collections.max(sumCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


}
