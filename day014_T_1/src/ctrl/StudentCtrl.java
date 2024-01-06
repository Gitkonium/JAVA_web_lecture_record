package ctrl;

import java.util.ArrayList;

import model.StudentDTO;
import model.StudentDAO;
import view.StudentView;

public class StudentCtrl {
	private StudentView view;
	private StudentDAO model;
	public StudentCtrl() {
		this.view=new StudentView();
		this.model=new StudentDAO();
	}
	public void startApp() {
		int PK=1003;
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
				ArrayList<StudentDTO> datas=model.selectAll();
				view.printDatas(datas);
			}
			else if(action==3) {
				int num=view.inputNum();
				StudentDTO data=model.selectOne(num);
				if(data==null) {
					view.printFalse();
					continue;
				}
				view.printData(data);
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
