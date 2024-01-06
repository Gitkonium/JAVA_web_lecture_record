package controller;

import java.util.ArrayList;

import model.Student;
import model.StudentModel;
import view.StudentView;

public class StudentCtrl {
	private StudentModel model;
	private StudentView view;
	public StudentCtrl() {
		this.model=new StudentModel();
		this.view=new StudentView();
	}

	public void startApp() {
		int PK=1002;
		while(true) {
			view.printMenu();
			int action=view.inputAction();
			if(action==0) {
				break;	
			}
			else if(action==1) {
				String name=view.inputName();
				int score=view.inputScore();
				boolean flag=model.insert(PK++, name, score);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==2) {
				ArrayList<Student> datas=model.selectAll();
				view.printStudentDatas(datas);
			}
			else if(action==3) {
				int num=view.inputNum();
				Student data=model.selectOne(num);
				if(data!=null) {
					view.printStudentData(data);
				}
				else {
					view.printFalse();
				}
			}
			else if(action==4) {
				int num=view.inputNum();
				int score=view.inputScore();
				boolean flag=model.update(num, score);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==5) {
				int num=view.inputNum();
				boolean flag=model.delete(num);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
		}
	}
}
