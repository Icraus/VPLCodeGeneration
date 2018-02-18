/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

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
public class CodeBlockTest {

    public CodeBlockTest() {
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
     * Test of toText method, of class CodeBlock.
     */
    @Test
    public void testToText() throws Exception {
        String expected = GrammerConstants.WHILE_STAT + GrammerConstants.OP_PARAN_START 
                + "x == 10" + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START
                + GrammerConstants.END_LINE
                + "String v = \"hello world\""
                + GrammerConstants.OP_END_LINE
                + GrammerConstants.END_LINE
                + "int i = 0"
                + GrammerConstants.OP_END_LINE
                + GrammerConstants.END_LINE
                + GrammerConstants.STAT_FOR
                + GrammerConstants.OP_PARAN_START 
                +"i = 0"
                + GrammerConstants.OP_END_LINE
                + " i < 10"
                + GrammerConstants.OP_END_LINE
                + " ++i"
                + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START
                + GrammerConstants.END_LINE 
                + GrammerConstants.STAT_IF
                + GrammerConstants.OP_PARAN_START
                + "i == 30"
                + GrammerConstants.OP_PARAN_END
                + GrammerConstants.OP_BLOCK_START
                + GrammerConstants.END_LINE
                + "String g = \"AA\""
                + GrammerConstants.OP_END_LINE
                + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END
                + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END
                + GrammerConstants.END_LINE
                + GrammerConstants.OP_BLOCK_END;
        String result = "";
        CodeBlock block = new CodeBlock();
        WhileCodeBlockHead head = new WhileCodeBlockHead();
        block.setHead(head);
        head.setCondition(new ConditionExpression("x == 10"));
        CodeBlockBody body = new CodeBlockBody();
        Statement st = new LineStatement(new DeclareExpression("String v = \"hello world\""));
        Statement st2 = new LineStatement(new DeclareExpression("int i = 0"));
        CodeBlock forblk = new CodeBlock();
        ForCodeBlockHead forblkHead = new ForCodeBlockHead();
        forblk.setHead(forblkHead);
        forblkHead.setCondition(new ConditionExpression("i < 10"));
        forblkHead.setDeclareExpression(new DeclareExpression("i = 0"));
        forblkHead.setPostItrExpression(new OperationExpression("++i"));
        CodeBlockBody forblkBody = new CodeBlockBody();
        forblk.setBody(forblkBody);
        CodeBlock ifcdblk =  new CodeBlock();
        forblkBody.getChildren().add(ifcdblk);
        IfCodeBlockHead ifhead = new IfCodeBlockHead();
        ifcdblk.setHead(ifhead);
        ifhead.setCondition(new ConditionExpression("i == 30"));
        CodeBlockBody ifcdblkBody = new CodeBlockBody();
        ifcdblk.setBody(ifcdblkBody);
        ifcdblkBody.getChildren().add(new LineStatement(new DeclareExpression("String g = \"AA\"")));
        body.getChildren().add(st);
        body.getChildren().add(st2);
        body.getChildren().add(forblk);
        block.setBody(body);
        
        result = block.toText();
        TestHelpers.printCases(expected, result);
        assertEquals(expected, result);
        TestHelpers.printFooter();

    }

}
