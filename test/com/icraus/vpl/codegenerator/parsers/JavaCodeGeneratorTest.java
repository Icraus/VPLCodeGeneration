/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator.parsers;

import com.icraus.vpl.codegenerator.GrammerConstants;
import com.icraus.vpl.codegenerator.TestHelpers;
import com.icraus.vpl.codegenerator.parsers.JavaCodeGenerator;
import java.util.Map;
import java.util.Properties;
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
public class JavaCodeGeneratorTest {

    public JavaCodeGeneratorTest() {
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
    public void testLoad() {
        String expected = "class";
        JavaCodeGenerator gen = new JavaCodeGenerator();
        Properties grammar = gen.getGrammar();
        String result = grammar.get(GrammerConstants.STAT_CLASS).toString();

        TestHelpers.printCases(expected, result);
        assertEquals(result, expected);
        TestHelpers.printFooter();
    }

    @Test
    public void testGenerateCode() {
        String expected = "class S"
                + "{"
                + "\n"
                + "while"
                + "("
                + "i > 0"
                + ")"
                + "{"
                + "\n"
                + "i++"
                + ";"
                + "\n"
                + "}"
                + "\n"
                + "}";
        String code = GrammerConstants.STAT_CLASS 
                + " S" 
                + GrammerConstants.OP_BLOCK_START
                + GrammerConstants.END_LINE
                + GrammerConstants.WHILE_STAT
                + GrammerConstants.OP_PARAN_START
                + "i > 0"
                + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START
                + GrammerConstants.END_LINE
                + "i++"
                + GrammerConstants.OP_END_LINE
                + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END
                + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END;
        
        
        
        JavaCodeGenerator gen = new JavaCodeGenerator();
        String result = gen.generateCode(code);
        TestHelpers.printCases(expected, result);
        assertEquals(result, expected);
        TestHelpers.printFooter();
    }

}
