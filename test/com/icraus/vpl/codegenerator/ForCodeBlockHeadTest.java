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
public class ForCodeBlockHeadTest {
    
    public ForCodeBlockHeadTest() {
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
    public void testToText() throws Exception {
        String expected = GrammerConstants.STAT_FOR + GrammerConstants.OP_PARAN_START 
                + "int i = 0"
                + GrammerConstants.OP_END_LINE
                + " i < 20"
                + GrammerConstants.OP_END_LINE 
                + " i = i + 1"
                + GrammerConstants.OP_PARAN_END; 
                
        String tst = expected.replace(GrammerConstants.STAT_FOR, "for");
        tst = tst.replace(GrammerConstants.OP_PARAN_END, ")");
        tst = tst.replace(GrammerConstants.OP_PARAN_START, "(");
        tst = tst.replace(GrammerConstants.OP_END_LINE, ";");
        System.out.println(tst);
        ForCodeBlockHead head = new ForCodeBlockHead();
        ConditionExpression cex = new ConditionExpression("i < 20");
        DeclareExpression dex = new DeclareExpression("int i = 0");
        OperationExpression op = new OperationExpression("i = i + 1");
        head.setCondition(cex);
        head.setDeclareExpression(dex);
        head.setPostItrExpression(op);
        String result = head.toText();
        printCases(expected, result);
        assertEquals(expected, result);
        printFooter();
    }

    
    
}
