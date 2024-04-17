package com.counteer.lotterystat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LuckyNumbers {

    @Value("${stat.hot.threshold}")
    private Long HOT_THRESHOLD;

    @Autowired
    private FileHandler fileHandler;

    @Autowired
    private SumOfDraw sumOfDraw;

    @Autowired
    private LuckyNumberSelector luckyNumberSelector;

    public List<List<Integer>> forecast() {
        List<int[]> previousDraws = fileHandler.readArchive(Integer.MAX_VALUE);
        int mostCommonDrawSum = sumOfDraw.getMostCommonDrawSum(previousDraws);
        Map<Integer, Long> frequencies = calculateFrequencies(previousDraws);
        List<Integer> hotNumbers = filterMapByValue(frequencies, x -> x > HOT_THRESHOLD);
        return luckyNumberSelector.findCombinations(hotNumbers, mostCommonDrawSum, 5);
    }

    private Map<Integer, Long> calculateFrequencies(List<int[]> draws) {
        return draws.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.groupingBy(
                i -> i,
                Collectors.counting()
        ));
    }

    private List<Integer> filterMapByValue(Map<Integer, Long> map, Predicate<Long> predicate) {
        return map.entrySet().stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
