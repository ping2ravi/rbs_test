package com.ravi.interview.service;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

    private final ConcurrentSkipListMap<Integer, Boolean> map;
    private int lastMaxNumber;

    public PrimeNumberServiceImpl() {
        map = new ConcurrentSkipListMap<Integer, Boolean>();
        map.put(2, true);
        lastMaxNumber = 2;
    }

    /* (non-Javadoc)
     * @see com.ravi.interview.service.PrimeNumberService#getPrimeNumbersUntill(int)
     */
    @Override
    public Set<Integer> getPrimeNumbersUntill(int max) {
        if (max > lastMaxNumber) {
            generateRandomNumber(max);
        }
        return map.headMap(max, true).keySet();
    }

    private void generateRandomNumber(int max) {
        int[] arr = new int[max + 1];
        int start = (lastMaxNumber / 2 > 2) ? lastMaxNumber / 2 : 2;
        for (int i = start; i <= max / 2; i++) {
            int jLoopMax = (i > max / i) ? max / i : i;
            for (int j = 2; j <= jLoopMax; j++) {
                arr[i * j] = 1;
            }
        }
        for (int i = lastMaxNumber; i < arr.length; i++) {
            if (arr[i] == 0) {
                map.putIfAbsent(i, true);
            }
        }
        lastMaxNumber = max;
    }
}
