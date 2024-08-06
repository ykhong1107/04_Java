package pkg3.dto;


// 인터페이스 상속 키워드 : implements (구현하다)

public class HYGCalculator implements Calculator{
	
	int max = Calculator.MAX_NUM;
	int min = Calculator.MIN_NUM;
	
	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = a / b;
		
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a % b;
		
		return result;
	}

	@Override
	public int pow(int a, int x) {
		double result = Math.pow(a, x);

		return (int) result;
	}

	@Override
	public double areaOfCircle(double r) {
		double result = Math.pow(r, r);
		
		return result;
	}

	@Override
	public String toBinary(int num) {
		String result = Integer.toBinaryString(num);
		
		return result;
	}

	@Override
	public String toHexadicimal(int num) {
		String result = Integer.toHexString(num);
		
		return result;
	}

	
	
	
}
