/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import java.util.ArrayList;
import java.util.List;

//TODO Add DECORATOR For access Modifiers, storage qualifier
public class ClassCodeBlockHead implements CodeBlockHead {
    public static final String VAR_CLASS_PARENT = "$$PARENT_CLASS";
    public static final String VAR_INTERFACES_NAME = "$$INTERFACE_CLASS";
    public static final String VAR_CLASS_NAME = "$$CLASS_NAME";
    public static final String CLASS_TEMPLATE = GrammerConstants.STAT_CLASS
            + " " 
            + VAR_CLASS_NAME
            + " "
            + GrammerConstants.STAT_EXTEND_WORD 
            + " "
            + VAR_CLASS_PARENT
            + " "
            + GrammerConstants.STAT_IMPLEMENTS_WORD 
            + " " 
            + VAR_INTERFACES_NAME; 


    private String className = "";
    private String parentClass = "";
    private List<String> interfaceNames = new ArrayList<>();
    private String statementTemplate ;

    public ClassCodeBlockHead() {
        this(CLASS_TEMPLATE);
    }
    protected ClassCodeBlockHead(String template){
        this.statementTemplate = CLASS_TEMPLATE;

    }
    public String getParentClass() {
        return parentClass.trim();
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }
    @Override
    public String getStatementTemplate() {
        return statementTemplate.trim();
    }

    @Override
    public String toText() throws ErrorGenerateCodeException {
        String res = getStatementTemplate();
        res = res.replace(VAR_CLASS_NAME, getClassName());
        res = res.replace(VAR_CLASS_PARENT, getParentClass());
        String interfaces = String.join(", ", getInterfaceNames()).trim();
        res = res.replace(VAR_INTERFACES_NAME, interfaces);
        return res.trim();
    }

    public String getClassName() {
        return className.trim();
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(List<String> interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    
}
