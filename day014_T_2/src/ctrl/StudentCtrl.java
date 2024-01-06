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
				StudentDTO studentDTO=new StudentDTO(PK++, name, score);
				boolean flag=model.insert(studentDTO);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==2) {
				StudentDTO studentDTO=new StudentDTO(0,null,0);
				ArrayList<StudentDTO> datas=model.selectAll(studentDTO);
				view.printDatas(datas);
			}
			else if(action==3) {
				int num=view.inputNum();
				StudentDTO studentDTO=new StudentDTO(num,null,0);
				StudentDTO data=model.selectOne(studentDTO);
				if(data==null) {
					view.printFalse();
					continue;
				}
				view.printData(data);
			}
			else if(action==4) {
				view.printUpdateMenu();
				action=view.inputAction();
				boolean flag;
				int num=view.inputNum();
				if(action==1) {
					int score=view.inputScore();
					StudentDTO studentDTO=new StudentDTO(num, null, score);
					flag=model.update(studentDTO);
				}
				else {
					String name=view.inputName();
					StudentDTO studentDTO=new StudentDTO(num, name, 0);
					flag=model.update(studentDTO);
				}
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==5) {
				int num=view.inputNum();
				StudentDTO studentDTO=new StudentDTO(num, null, 0);
				boolean flag=model.delete(studentDTO);
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
