/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 5, 2024
 */

package com.sunbeam;

public class CalcBean {
	private int num1;
	private int num2;
	private String op;
	private int result;
	
	public CalcBean() {
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public void calculate() {
		switch (this.op) {
		case "+":
			this.result = this.num1 + this.num2;
			break;
		case "-":
			this.result = this.num1 - this.num2;
			break;
		case "*":
			this.result = this.num1 * this.num2;
			break;
		case "/":
			this.result = this.num1 / this.num2;
			break;
		case "%":
			this.result = this.num1 % this.num2;
			break;
		}
	}
}
