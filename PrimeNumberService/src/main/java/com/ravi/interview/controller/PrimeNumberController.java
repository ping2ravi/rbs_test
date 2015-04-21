package com.ravi.interview.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.interview.controller.dto.PrimeNumberResult;
import com.ravi.interview.service.PrimeNumberService;

@Controller
@RequestMapping("/primes")
public class PrimeNumberController {

    @Autowired
    private PrimeNumberService primeNumberService;

    @RequestMapping(value = "/{max}", method = RequestMethod.GET)
    @ResponseBody
    public PrimeNumberResult getPrimeNumbers(@PathVariable int max) {

        Set<Integer> primeNumbers = primeNumberService.getPrimeNumbersUntill(max);
        return new PrimeNumberResult(max, primeNumbers);
    }
}
