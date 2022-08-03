package com.example.sangsakaair.currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyApiTest {
    @Test
    void testConversion() throws Exception{
        String from = "IDR";
        String to = "USD";
        double value = 100000;
        double result = CurrencyApi.convertCurrency(from, to, value);
        assert Math.abs(6.71 - result) <= 1;
        Exception e = assertThrows(Exception.class, ()-> {
            CurrencyApi.convertCurrency(from, "121321", value);
        });
    }
}
