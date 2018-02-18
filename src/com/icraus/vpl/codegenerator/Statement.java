/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

/**
 *
 * @author Shoka
 */
public abstract class Statement  implements CodeGenerator{
    private String statementString = "";
    private CodeBlockImports imports = new CodeBlockImportsImpl();

    public Statement() {
    }

    public Statement(String st) {
        statementString = st;
    }

    public String getStatementString() {
        return statementString;
    }

    public void setStatementString(String statementString) {
        this.statementString = statementString;
    }
    
    public CodeBlockImports getImports() {
        return imports;
    }

    public void setImports(CodeBlockImports imports) {
        this.imports = imports;
    }

}
