package com.example.testclass;

import com.example.implemantation.Addition;
import com.example.implemantation.Divison;
import com.example.implemantation.Subtraction;
import com.example.minterface.MathInterface;

public class MainClass {
	public static void main(String[] args) {
		// this for Addtion opertation
		MathInterface addition=new Addition();
		int result = addition.perform(10, 5);
		System.out.println(result);
		// this for subtraction opertation
		MathInterface subtraction= new Subtraction();
		int result1 = subtraction.perform(10, 5);
		System.out.println(result1);
		// this for divison opertation
		MathInterface divison=new Divison();
		int result2 = divison.perform(10, 5);
		System.out.println(result2);
		
		
		
	}

}
