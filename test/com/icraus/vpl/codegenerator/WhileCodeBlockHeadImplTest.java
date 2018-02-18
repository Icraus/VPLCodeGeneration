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
public class WhileCodeBlockHeadImplTest {
    
    public WhileCodeBlockHeadImplTest() {
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
    
    @Test
    public void testToText() throws ErrorGenerateCodeException {
        String expected = GrammerConstants.WHILE_STAT
                + GrammerConstants.OP_PARAN_START + "i < 20"
                + GrammerConstants.OP_PARAN_END;
        WhileCodeBlockHead head = new WhileCodeBlockHead();
        head.setCondition(new ConditionExpression("i < 20"));
        String result = head.toText();
        printCases(expected, result);
        assertEquals(expected, result);
        printFooter();
        
    }
    
}
