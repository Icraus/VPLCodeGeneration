/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator.parsers;

import com.icraus.vpl.codegenerator.ClassCodeBlockHead;
import com.icraus.vpl.codegenerator.CodeBlock;
import com.icraus.vpl.codegenerator.CodeBlockBody;
import com.icraus.vpl.codegenerator.ErrorGenerateCodeException;
import com.icraus.vpl.codegenerator.GrammerConstants;
import com.icraus.vpl.codegenerator.SimpleStatement;
import com.icraus.vpl.codegenerator.TestHelpers;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Test
    public void testClassCodeGeneration() {
        CodeBlock b = new CodeBlock();
        b.setBody(new CodeBlockBody());
        b.getBody().getChildren().add(new SimpleStatement("while(1);"));
        ClassCodeBlockHead h = new ClassCodeBlockHead();
        h.setClassName("SS");
        h.setPackageName("Package");
        h.setInterfaceNames(new ArrayList<>());
        h.setParentClass("");
        b.setHead(h);
        h.setAccessType("public");
        try {
            String txt = b.toText();
            JavaCodeGenerator c = new JavaCodeGenerator();
            c.generateClass("C:/1", h.getClassName(), txt);
        } catch (ErrorGenerateCodeException ex) {
            Logger.getLogger(JavaCodeGeneratorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
