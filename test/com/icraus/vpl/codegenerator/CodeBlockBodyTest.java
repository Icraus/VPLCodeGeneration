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
public class CodeBlockBodyTest {
    
    public CodeBlockBodyTest() {
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
     * Test of toText method, of class CodeBlockBody.
     */
    @Test
    public void testToText() throws Exception {
            String expected = "String s = \\\"Hello World\\\"" + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE;
            expected += "int xx = 5" + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE;
            expected += "x == 20" + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE;
            CodeBlockBody body = new CodeBlockBody();
            Expression s = new DeclareExpression("String s = \\\"Hello World\\\"");
            Expression i = new DeclareExpression("int xx = 5");
            Expression c = new ConditionExpression("x == 20");
            Statement l1 = new LineStatement(s);
            Statement l2 = new LineStatement(i);
            Statement l3 = new LineStatement(c);
            body.getChildren().add(l1);
            body.getChildren().add(l2);
            body.getChildren().add(l3);
            String result = body.toText();
            printCases(expected, result);
            assertEquals(result, expected);
            printFooter();
    }
    
}
