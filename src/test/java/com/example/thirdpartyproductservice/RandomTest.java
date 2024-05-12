package com.example.thirdpartyproductservice;

import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    void testIsOnePlusOneIsTwo(){
        int i=1+1; //Assert + Act

        //Assert -> check against the expected value
        assert i==2;
        
    }
}


/*

Test case is nothing but a method that tests aa particular functionality
across the expected value

3A
-----

Arrange
Act
Assert

 */