/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import java.util.List;
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
public class ClassCodeBlockHeadTest {
    
    public ClassCodeBlockHeadTest() {
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
     * Test of toText method, of class ClassCodeBlockHead.
     */
    @Test
    public void testToText() throws Exception {
        String expect = GrammerConstants.STAT_CLASS
                + " "
                + "Customer"
                + " "
                + GrammerConstants.STAT_EXTEND_WORD + " "
                + "Person "
                + GrammerConstants.STAT_IMPLEMENTS_WORD
                + " Code, Personal"
                ;
        
        ClassCodeBlockHead head = new ClassCodeBlockHead();
        head.setClassName("Customer");
        head.setParentClass("Person");
        head.getInterfaceNames().add("Code");
        head.getInterfaceNames().add("Personal");
        String result = head.toText();
        TestHelpers.printCases(expect, result);
        assertEquals(expect, result);
        TestHelpers.printFooter();
    }

    
}
