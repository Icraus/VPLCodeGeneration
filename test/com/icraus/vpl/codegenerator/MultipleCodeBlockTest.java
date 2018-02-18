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
public class MultipleCodeBlockTest {
    
    public MultipleCodeBlockTest() {
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
     * Test of toText method, of class MultipleCodeBlock.
     */
    

    /**
     * Test of getStatementTemplate method, of class MultipleCodeBlock.
     */
    @Test
    public void testToText() throws ErrorGenerateCodeException {
        String expect = GrammerConstants.STAT_IF
                + GrammerConstants.OP_PARAN_START 
                + "x == 10"
                + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START + GrammerConstants.END_LINE
                + "String s = \"A\""
                + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END
                + GrammerConstants.STAT_IF
                + GrammerConstants.OP_PARAN_START 
                + "x == 30"
                + GrammerConstants.OP_PARAN_END 
                + GrammerConstants.OP_BLOCK_START + GrammerConstants.END_LINE
                + "String s = \"B\""
                + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END
                + GrammerConstants.STAT_IF
                + GrammerConstants.OP_PARAN_START 
                + "x == 0"
                + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START + GrammerConstants.END_LINE
                + "String s = \"C\""
                + GrammerConstants.OP_END_LINE + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END;
        String result = "";
        MultipleCodeBlock blcks = new MultipleCodeBlock();
        CodeBlock initalBlock = new CodeBlock();
        blcks.setInitalBlock(initalBlock);
        CodeBlockBody initBody = new CodeBlockBody();
        initBody.getChildren().add(new LineStatement(new DeclareExpression("String s = \"A\"")));
        initalBlock.setBody(initBody);
        IfCodeBlockHead initHead = new IfCodeBlockHead();
        initHead.setCondition(new ConditionExpression("x == 10"));
        initalBlock.setHead(initHead);
        
        
        
        CodeBlock finalBlock = new CodeBlock();
        blcks.setFinalBlock(finalBlock);
        CodeBlockBody finalBody = new CodeBlockBody();
        finalBody.getChildren().add(new LineStatement(new DeclareExpression("String s = \"C\"")));
        finalBlock.setBody(finalBody);
        IfCodeBlockHead finalHead = new IfCodeBlockHead();
        finalHead.setCondition(new ConditionExpression("x == 0"));
        finalBlock.setHead(finalHead);
        
        
        
        
        CodeBlock block = new CodeBlock();
        blcks.getCodeBlocks().add(block);
        CodeBlockBody blockBody = new CodeBlockBody();
        blockBody.getChildren().add(new LineStatement(new DeclareExpression("String s = \"B\"")));
        block.setBody(blockBody);
        IfCodeBlockHead bodyHead = new IfCodeBlockHead();
        bodyHead.setCondition(new ConditionExpression("x == 30"));
        block.setHead(bodyHead);
        result = blcks.toText();
        
        TestHelpers.printCases(expect, result);
        assertEquals(expect, result);
        TestHelpers.printFooter();
    }
    
}
