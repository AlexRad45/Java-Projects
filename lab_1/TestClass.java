/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrad
 */
public class TestClass{

    public static void main(String[] args) {
        String pos = "123";
        String neg = "-45";
        
        try{
        HugeInteger first = new HugeInteger(pos);
        System.out.println("A positive array:" + first.toString());
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Input");
        }

        try{
        HugeInteger second = new HugeInteger(neg);
        System.out.println("A negative array:" + second.toString());
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Input");
        }

        try{
        HugeInteger third = new HugeInteger(5);
        System.out.println("A random array:" + third.toString());
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Input");
        }

        // addition
        System.out.println("\n ADD() method test \n");

        String test1 = "-10096";
        String test2 = "1014";
        HugeInteger numadd = new HugeInteger(test1);
        HugeInteger numadd1 = new HugeInteger(test2);
        System.out.println("result of multiply: " + (numadd.multiply(numadd1)).toString());
        System.out.println("result of compare: " + (numadd.compareTo(numadd1)));
        System.out.println("Test Number for addition: " + numadd.toString());
        System.out.println("Test Number for addition: " + numadd1.toString());
        System.out.println("result of addition is: " + (numadd.add(numadd1)).toString());
        numadd = new HugeInteger(test1);
        numadd1 = new HugeInteger(test2);
        System.out.println("Test Number for subtraction: " + numadd.toString());
        System.out.println("Test Number for subtraction: " + numadd1.toString());
        System.out.println("result of subtraction is: " + (numadd.subtract(numadd1)).toString());
    }
}