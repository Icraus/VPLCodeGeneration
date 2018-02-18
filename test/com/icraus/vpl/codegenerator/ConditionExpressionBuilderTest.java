/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import static com.icraus.vpl.codegenerator.TestHelpers.printCases;
import static com.icraus.vpl.codegenerator.TestHelpers.printFooter;
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
public class ConditionExpressionBuilderTest {

    public ConditionExpressionBuilderTest() {
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

    
    /**
     * Test of ConditionExpression method, of class ConditionExpressionBuilder.
     */
    @Test
    public void testConditionExpression() {
        printFooter();
    }

    /**
     * Test of appendAndCondition method, of class ConditionExpressionBuilder.
     */
    @Test
    public void testAppendAndCondition() {
        printFooter();

    }

    /**
     * Test of appendOrCondition method, of class ConditionExpressionBuilder.
     */
    @Test
    public void testAppendOrCondition() {
        printFooter();

    }

    /**
     * Test of buildConditionList method, of class ConditionExpressionBuilder.
     */
    @Test
    public void testBuildConditionList() {
        ConditionExpressionBuilder builder = new ConditionExpressionBuilder();
        String expected = "i < 5 && b < 10 || c == 20";
        builder.appendAndCondition("i < 5");
        builder.appendAndCondition("b < 10");
        builder.appendOrCondition("c == 20 ");
        String result = builder.buildConditionList();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();

    }
    @Test
    public void testAppendConditionType() {
        ConditionExpression c = new ConditionExpression("i < 5");
        String expected = "i < 5 && i < 5 || i < 5 && b < 10 || c == 20";
        ConditionExpressionBuilder builder = new ConditionExpressionBuilder();
        builder.appendAndCondition(c);
        builder.appendAndCondition(c);
        builder.appendOrCondition(c);

        builder.appendAndCondition("b < 10");
        builder.appendOrCondition("c == 20 ");
        String result = builder.buildConditionList();
        printCases(expected, result);
        assertEquals(expected, result);

    }

    /**
     * Test of buildExpression method, of class ConditionExpressionBuilder.
     */
    @Test
    public void testBuildExpression() {

    }

}
