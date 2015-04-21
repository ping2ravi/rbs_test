package com.ravi.interview.service;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumberServiceTest {

    private PrimeNumberServiceImpl primeNumberServiceImpl;

    @Before
    public void init() {
        primeNumberServiceImpl = new PrimeNumberServiceImpl();
    }

    @Test
    public void test01() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(10);
        Assert.assertEquals(4, primes.size());
        Assert.assertTrue(primes.contains(2));
        Assert.assertTrue(primes.contains(3));
        Assert.assertTrue(primes.contains(5));
        Assert.assertTrue(primes.contains(7));
    }

    @Test
    public void test02() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(1);
        Assert.assertEquals(0, primes.size());
    }

    @Test
    public void test03() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(2);
        Assert.assertEquals(1, primes.size());
        Assert.assertTrue(primes.contains(2));
    }

    @Test
    public void test04() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(3);
        Assert.assertEquals(2, primes.size());
        Assert.assertTrue(primes.contains(2));
        Assert.assertTrue(primes.contains(3));
    }

    @Test
    public void test05() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(0);
        Assert.assertEquals(0, primes.size());
    }

    @Test
    public void test06() {
        Set<Integer> primes = primeNumberServiceImpl.getPrimeNumbersUntill(-10);
        Assert.assertEquals(0, primes.size());
    }
}
