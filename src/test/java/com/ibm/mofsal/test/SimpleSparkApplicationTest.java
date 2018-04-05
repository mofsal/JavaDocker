package com.ibm.mofsal.test;

import org.junit.Test;

import com.ibm.mofsal.SimpleSparkApplication;

import static org.junit.Assert.*;

public class SimpleSparkApplicationTest {
	@Test 
    public void countLiness() {
    	long count = 48;
        assertEquals(count, SimpleSparkApplication.countLines());
    }
    @Test 
    public void countLinesWithAs() {
    	long numAs = 43;
        assertEquals(numAs, SimpleSparkApplication.countLinesWithAs());
    }
}
