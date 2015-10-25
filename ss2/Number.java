/**
 * Lop so phuc, 1 so phep toan cua so phuc
 */
public class Number {
	double real;
	double imaginary;
	/*
	 * Contructor
	 */
	Number(double x, double y) {
		this.real = x;
		this.imaginary = y;
	}
	/*
	 * phuong thuc lay phan thuc 
	 */
	public double getReal() {
		return real;
	}
	/*
	 * phuong thuc lay phan ao
	 */
	public double getImaginary() {
		return imaginary;
	}
	/*
	 * phuong thuc toString
	 */
	public String getComplexNumber() {
		String number = "";
		if (real != 0) {
			number += real;
		}
		if (imaginary < 0) {
			number = number + imaginary + "i"; 
		}
		else {
			if (imaginary == 0) {
				number = number + "i";
			}
			else {
				number = number + "+" + imaginary + "i";
			}
		}
		return number; 
	}
	/*
	 * cong 2 so phuc
	 */
	public Number addComplexNumber(Number number) {
		double nReal;
		double nImaginary;
		nReal = number.getReal() + real;
		nImaginary = number.getImaginary() + imaginary;
		return new Number(nReal, nImaginary);
	}
	/*
	 * tru 2 so phuc
	 */
	public Number subComplexNumber(Number number) {
		double nReal;
		double nImaginary;
		nReal = number.getReal() - real;
		nImaginary = number.getImaginary() - imaginary;
		return new Number(nReal, nImaginary);
	}
	/*
	 * nhan 2 so phuc
	 */
	public Number mulComplexNumber(Number number) {
		double nReal;
		double nImaginary;
		double a1 = number.getReal();
		double b1 = number.getImaginary();
		double a2 = real;
		double b2 = imaginary;
		nReal = a1 * a2 - b1 * b2;
		nImaginary = a1 * b2 + a2 * b1;
		return new Number(nReal, nImaginary);
	}
	/*
	 * chia 2 so phuc
	 */
	public Number divComplexNumber(Number number) {
		double nReal;
		double nImaginary;
		double a1 = number.getReal();
		double b1 = number.getImaginary();
		double a2 = real;
		double b2 = imaginary;
		nReal = (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2);
		nImaginary = (b1 * a2 - b2 * a1) /  (a2 * a2 + b2 * b2);
		return new Number(nReal, nImaginary);
	}
	/*
	 * tinh module so phuc
	 */
	public double getModul(){
		return Math.pow(real, 2) + Math.pow(imaginary, 2);
	}
	public static void main(String []args) {
		Number number1 = new Number(1,-4);
		Number number2 = new Number(6,2);
		System.out.println(number1.addComplexNumber(number2).getComplexNumber());
	}
}
