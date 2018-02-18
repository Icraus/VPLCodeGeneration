/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator;

import java.util.Objects;

/**
 *
 * @author Shoka
 */
public abstract class Expression {
    private String expressionStr = "";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.expressionStr);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Expression other = (Expression) obj;
        if (!Objects.equals(this.expressionStr, other.expressionStr)) {
            return false;
        }
        return true;
    }

    public String getExpressionStr() {
        return expressionStr.trim();
    }

    public void setExpressionStr(String expressionStr) {
        this.expressionStr = expressionStr.trim();
    }
    
            
}
