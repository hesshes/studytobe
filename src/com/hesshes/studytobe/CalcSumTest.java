package com.hesshes.studytobe;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

//list 3-36
public class CalcSumTest {

    Calculator calc;
    String numFilepath;

    @Before
    public void setup() {
        this.calc = new Calculator();
        this.numFilepath = getClass().getResource("number.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calc.calcSum(this.numFilepath), is(10));
    }

    @Test
    public void calcMultiply(String filepath) throws IOException {
        assertThat(calc.calcMultiply(this.numFilepath), is(24));
    }
}
