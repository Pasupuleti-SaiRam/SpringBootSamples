package com.example.implemantation;

import com.example.minterface.MathInterface;

public class Addition implements MathInterface {

	@Override
	public int perform(int a, int b) {
		return a+b;
	}
	

}
