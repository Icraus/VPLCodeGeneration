/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import com.icraus.vpl.codegenerator.DeclareExpressionBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shoka
 */
public class DeclareExpressionBuilderTest {
    
    public DeclareExpressionBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    void printFooter(){
        System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " = true");
        System.out.println("------------- ---------------- ---------------");

    }
    void printCases(String expect, String res) {
        System.out.println("expected-------------------\n" + expect);
        System.out.println("Result-------------------\n" + res);
        
    }
    @Test
    public void testDeclareExpression() {
        String expected = "int i = 0";
        DeclareExpressionBuilder builder = new DeclareExpressionBuilder();
        builder.setVarType("int");
        builder.setVarValue("i", "0");
        String result = builder.buildVarExpression();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
        
    }
    @Test
    public void testObjectDeclareExp() {
        String expected = "Widget i = new Widget()";
        DeclareExpressionBuilder builder = new DeclareExpressionBuilder();
        builder.setVarType("Widget");
        builder.setVarValue("i", "new Widget()");
        String result = builder.buildVarExpression();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
    }
    @Test
    public void testNoAssignment() {
        String expected = "Widget i";
        DeclareExpressionBuilder builder = new DeclareExpressionBuilder();
        builder.setVarType("Widget");
        builder.setVarValue("i", "");
        String result = builder.buildVarExpression();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
        
    }
    
    
}
