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
public class TestHelpers {
    public static void printFooter(){
        String clazzName = Thread.currentThread().getStackTrace()[2].getClassName();
        clazzName = clazzName.substring(clazzName.lastIndexOf(".") + 1);
        System.out.println( clazzName + " :: " + Thread.currentThread().getStackTrace()[2].getMethodName() + " = true");
        System.out.println("------------- ---------------- ---------------");

    }
    public static void printCases(String expect, String res) {
        System.out.println("expected-------------------\n" + expect);
        System.out.println("Result-------------------\n" + res);
        if(!expect.equals(res)){
            int i = expect.compareTo(res);
            String str = res.substring(i);
            System.out.println("Error at:\n " + str);
        }
        
    }
}
