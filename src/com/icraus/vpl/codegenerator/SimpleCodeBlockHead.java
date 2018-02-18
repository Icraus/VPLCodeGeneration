/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;


public class SimpleCodeBlockHead implements CodeBlockHead {

    private String head;
    public SimpleCodeBlockHead(String _head){
        head  = _head;
    }
    @Override
    public String getStatementTemplate() {
        return "";
    }

    @Override
    public String toText() throws ErrorGenerateCodeException {
        return head;
    }
    
}
