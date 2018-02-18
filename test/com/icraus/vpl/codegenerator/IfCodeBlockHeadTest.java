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
public class IfCodeBlockHeadTest {

    public IfCodeBlockHeadTest() {
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
     * Test of toText method, of class IfCodeBlockHead.
     */
    @Test
    public void testToText() throws Exception {
        String expected = GrammerConstants.STAT_IF
                + GrammerConstants.OP_PARAN_START
                + "x == 10"
                + GrammerConstants.OP_PARAN_END;
        String tst = expected.replace(GrammerConstants.STAT_IF, "if");
        tst = tst.replace(GrammerConstants.OP_PARAN_START, "(");
        tst = tst.replace(GrammerConstants.OP_PARAN_END, ")");
        System.out.println(tst);
        IfCodeBlockHead head = new IfCodeBlockHead();
        ConditionExpression condition = new ConditionExpression("x == 10");
        head.setCondition(condition);
        String result = head.toText();
        printCases(expected, result);
        assertEquals(expected, result);
        printFooter();
    }

}
