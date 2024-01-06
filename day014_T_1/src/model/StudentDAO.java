package model;

import java.util.ArrayList;

public class StudentDAO {
	private ArrayList<StudentDTO> datas; // DB의 역할
	public StudentDAO() {
		this.datas=new ArrayList<StudentDTO>();
		this.datas.add(new StudentDTO(1001,"티모",50));
		this.datas.add(new StudentDTO(1002,"아리",89));
	}

	// R : 데이터 반환이 목표
	public ArrayList<StudentDTO> selectAll(){
		return datas;
	}
	public StudentDTO selectOne(int num) {
		boolean flag=false;
		int i;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==num) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return null;
		}
		return datas.get(i);
	}

	public boolean insert(int num,String name,int score) {
		this.datas.add(new StudentDTO(num,name,score));
		return true;
	}
	public boolean update(int num,int score) {
		boolean flag=false;
		int i;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==num) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		datas.get(i).setScore(score);
		return true;
	}
	public boolean delete(int num) {
		boolean flag=false;
		int i;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==num) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		datas.remove(i);
		return true;
	}
}
