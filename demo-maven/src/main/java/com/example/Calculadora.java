package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	
	private double redondea(double a) {
		return (new BigDecimal(a)).setScale(15, RoundingMode.HALF_UP).doubleValue();
	}
	
	double add(double a, double b) {
		return redondea(a+b);
	}

	double div(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by 0");
		
		return redondea(a/b);
	}
	
	int div(int a, int b) {	
		return a/b;
	}
}
