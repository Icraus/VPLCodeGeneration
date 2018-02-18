/*
 * To change this license head, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shoka
 */
public class CodeBlock extends Statement {

    public static final String HEAD_STAT = "$$HEAD_STAT";
    public static final String BODY_STAT = "$$BODY_STAT";
    public static final String CODE_BLOCK_TEMPLATE
            = HEAD_STAT
            + GrammerConstants.OP_BLOCK_START
            + GrammerConstants.END_LINE
            + BODY_STAT
//            + GrammerConstants.END_LINE
            + GrammerConstants.OP_BLOCK_END;

    private CodeBlockHead head = null;
    private CodeBlockBody body = null;

    public CodeBlockHead getHead() {
        return head;
    }

    public void setHead(CodeBlockHead head) {
        this.head = head;
    }

    public CodeBlockBody getBody() {
        return body;
    }

    public void setBody(CodeBlockBody body) {
        this.body = body;
    }

    @Override
    public String toText() throws ErrorGenerateCodeException {
        String res = CODE_BLOCK_TEMPLATE;
        try {
            res = res.replace(HEAD_STAT, head.toText());
            res = res.replace(BODY_STAT, body.toText());
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new ErrorGenerateCodeException();
        }
        return res.trim();
    }

}
