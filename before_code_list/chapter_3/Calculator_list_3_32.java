package com.hesshes.studytobe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// list 3-32
public class Calculator {
    public Integer calcSum(String filePath) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            Integer sum = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.valueOf(line);
            }
            br.close();
            return sum;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }

    }

}
