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
public class BasicCodeBlockImportsImplTest {
    
    public BasicCodeBlockImportsImplTest() {
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
     * Test of toText method, of class CodeBlockImportsImpl.
     */
    @Test
    public void testToText() {
        String expected = GrammerConstants.STAT_IMPORT + " package " + GrammerConstants.OP_END_LINE;
        CodeBlockImportsImpl imports = new CodeBlockImportsImpl();
        imports.getPackageLst().add("package");
        String result = imports.toText();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
    }
     @Test
    public void testMutliplePackages() {
        String expected = GrammerConstants.STAT_IMPORT + " package " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " com.widget.Icraus " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " com.class.Sun " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " package " + GrammerConstants.OP_END_LINE;
        expected = expected.trim();
        CodeBlockImportsImpl imports = new CodeBlockImportsImpl();
        imports.getPackageLst().add("package");
        imports.getPackageLst().add("com.widget.Icraus");
        imports.getPackageLst().add("com.class.Sun");
        imports.getPackageLst().add("package");
        String result = imports.toText();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
    }
     @Test
    public void testMutlipleIncludes() {
        String expected = GrammerConstants.STAT_IMPORT + " <helloWorld.h> " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " <myName> " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " <solongSucker.h> " + GrammerConstants.OP_END_LINE + "\n";
        expected += GrammerConstants.STAT_IMPORT + " <package> " + GrammerConstants.OP_END_LINE;
        expected = expected.trim();
        CodeBlockImportsImpl imports = new CodeBlockImportsImpl();
        imports.getPackageLst().add("<helloWorld.h>");
        imports.getPackageLst().add("<myName>");
        imports.getPackageLst().add("<solongSucker.h>");
        imports.getPackageLst().add("<package>");
        String result = imports.toText();
        printCases(expected, result);
        assertEquals(result, expected);
        printFooter();
    }
}
