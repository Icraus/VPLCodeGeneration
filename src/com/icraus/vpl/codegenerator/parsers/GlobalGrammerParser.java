/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icraus.vpl.codegenerator.parsers;

import com.icraus.vpl.codegenerator.CodeGenerator;
import com.icraus.vpl.codegenerator.ErrorGenerateCodeException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shoka
 */
public class GlobalGrammerParser {

    private static GlobalGrammerParser instance = new GlobalGrammerParser();
    private JavaCodeGenerator jGrammar = new JavaCodeGenerator();

    List<CodeGenerator> code = new ArrayList<>();

    public static GlobalGrammerParser getInstance() {
        return instance;
    }

    public String generateCode() {
        String res = "";
        try {
            for (CodeGenerator c : code) {

                res += c.toText();
            }
        } catch (ErrorGenerateCodeException ex) {
            Logger.getLogger(GlobalGrammerParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
