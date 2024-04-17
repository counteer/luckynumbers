package com.counteer.lotterystat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class FileHandler {
    public static final int FIRST_NUMBER_COLUMN = 11;
    public static final int LAST_NUMBER_COLUMN = 16;
    public static final String SEPARATOR = ";";

    @Value("${stat.file.name}")
    private String statFileName;



    List<int[]> readArchive(int limit) {
        try (InputStream in = this.getClass()
                .getClassLoader().getResourceAsStream(statFileName);
             InputStreamReader isr = new InputStreamReader(in);
             var br = new BufferedReader(isr)) {
            int lineCount = 0;
            String line;

            List<int[]> numbers = new ArrayList<>();

            while ((line = br.readLine()) != null && lineCount < limit) {
                numbers.add(Arrays.stream(Arrays.copyOfRange(line.split(SEPARATOR), FIRST_NUMBER_COLUMN, LAST_NUMBER_COLUMN))
                        .mapToInt(Integer::parseInt)
                        .toArray());
            }
            return numbers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}