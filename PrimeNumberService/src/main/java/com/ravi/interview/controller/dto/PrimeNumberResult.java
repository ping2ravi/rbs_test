package com.ravi.interview.controller.dto;

import java.util.Set;

public class PrimeNumberResult {
    private int Initial;
    private Set<Integer> Primes;

    public PrimeNumberResult(int initial, Set<Integer> primes) {
        super();
        Initial = initial;
        Primes = primes;
    }

    public int getInitial() {
        return Initial;
    }

    public Set<Integer> getPrimes() {
        return Primes;
    }

}
