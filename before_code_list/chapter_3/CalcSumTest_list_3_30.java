package com.hesshes.studytobe;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.io.IOException;

import org.junit.Test;

//list 3-30
public class CalcSumTest {

    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum(getClass().getResource("number.txt").getPath());
        assertThat(sum, is(10));
    }

}
