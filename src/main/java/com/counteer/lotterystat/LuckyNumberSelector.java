package com.counteer.lotterystat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LuckyNumberSelector {

    public  List<List<Integer>> findCombinations(List<Integer> numbers, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(result, numbers, target, k, combination, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> numbers, int target, int k, List<Integer> combination, int start) {
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || k == 0) {
            return;
        }
        for (int i = start; i < numbers.size(); i++) {
            combination.add(numbers.get(i));
            backtrack(result, numbers, target - numbers.get(i), k - 1, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

}
