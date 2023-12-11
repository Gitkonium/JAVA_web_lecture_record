package controller;

import model.CalcModel;
import view.CalcView;

// Ctrl는 절대로 자신스스로 기능을 구현 xxx
// M,V을 호출하여 사용!
public class CalcCtrl {

	private CalcModel model;
	private CalcView view;

	public CalcCtrl() {
		model=new CalcModel();
		view=new CalcView();
	}

	public void startApp() {
		view.printInputInteger(1);
		int num1=view.inputInteger();

		view.printInputOp();
		String op=view.inputStringOp();

		view.printInputInteger(2);
		int num2=view.inputInteger();

		int result;
		if(op.equals("+")) {
			result=model.func01(num1, num2);
		}
		else if(op.equals("-")) {
			result=model.func02(num1, num2);
		}
		else {
			result=model.func03(num1, num2);
		}
		
		view.printResult(num1, op, num2, result);
	}

}











