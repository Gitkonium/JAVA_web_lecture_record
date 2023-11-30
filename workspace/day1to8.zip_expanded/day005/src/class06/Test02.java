package class06;

public class Test02 {

	public static void funcA(int a, int b) {

		System.out.println("[1]");

		// -> 
		double c = a * 1.0;

		// function(17.0,17.0)
		 funcA(c,c);

	}

	public static void funcA(int a, double b) {

		System.out.println("[2]");

		double result = a + b;

		System.out.println(a + " + " + b + " = " + result);

	}

	public static void funcA(double a, double b) {

		System.out.println("[3]");

		double result = a - b;

		System.out.println(result);

	}

	public static int funcB(int num) {

		System.out.println("[4]");

		return num * 10;

	}

	public static int funcC(int[] datas) {

		System.out.println("[5]");

		datas[datas.length - 1] = -2;

		return datas.length;

	}

	public static void main(String[] args) {

		int[] numArr = new int[5];

		for (int i = 0; i < numArr.length; i++) {

			numArr[i] = (i + 1) * 10;

		}

		System.out.println("결과는 " + funcC(numArr));

		for (int num : numArr) {

			System.out.print(num + " ");

		}

		System.out.println();

		int num = 1;

		num = funcB(num);

		System.out.println("num= " + num);

		int a = 17;

		int b = 18;

		double c = 3.14;

		// 기능이 유사하거나 같아서 "함수명 중복정의를 허용"
		funcA(a, b);

		// == 오버로딩
		funcA(b, c);

		//15번 라인 public static void 
		funcA(c, b);

		System.out.println("a= " + a);

		System.out.println("b= " + b);

		System.out.println("c= " + c);

	}

}
