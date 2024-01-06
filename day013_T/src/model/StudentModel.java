package model;

import java.util.ArrayList;

public class StudentModel {

	// CRRUD
	// 만약 메서드가 5개보다 적거나 많으면 어라...?? 이상감지해야함

	private ArrayList<Student> datas;

	public StudentModel() {
		datas=new ArrayList<Student>();
		datas.add(new Student(1001,"홍길동",50));
	}
	
	public ArrayList<Student> selectAll() {
		return datas;
	}
	public Student selectOne(int num) {
		for(Student data:datas) {
			if(data.getNum()==num) {
				return data;
			}
		}
		return null; // 검색할 학생이 없다면, null이 반환됨
	}
	// Q1. 성이 김씨인 학생 출력 -> selectAll()
	// Q2. 1002번 학생 출력 -> selectOne()
	// Q3. 1등 출력 -> selectAll() : 2명이상일수도있는 액션은 전부 All()

	public boolean insert(int num,String name,int score) {
		datas.add(new Student(num,name,score));
		System.out.println("   [로그] insert 메서드 수행");
		return true;
	}
	public boolean update(int num,int score) {
		// num 유효성은 데이터를 봐야지만 알수있음
		// score는 VIEW에서 체크가능
		boolean flag=false;
		int i;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==num) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("   [로그] update 메서드 실패");
			return false;
		}
		
		datas.get(i).setScore(score);
		System.out.println("   [로그] update 메서드 성공");
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
			System.out.println("   [로그] delete 메서드 실패");
			return false;
		}
		
		datas.remove(i);
		System.out.println("   [로그] delete 메서드 성공");
		return true;
	}


}
