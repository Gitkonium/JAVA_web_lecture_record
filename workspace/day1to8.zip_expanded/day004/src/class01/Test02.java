package class01;

import java.util.Scanner;

public class Test02 
{

	public static void main(String[] args) 
	{
		
		// 변수 선언하기
		// 여러명의 학생 점수 데이터를 저장할 예정
		// 몇개인지 정확하지않아서 배열은 원래 사용 xxx
		// 그래서! 우리는! 학생의 최대 명수를 고정하고 사용하겠습니다!
		// 학생 최대 5명까지 저장가능한 프로그램 ☆
		int[] student=new int[5];
		
		// 현재 저장된 학생의 명수
		int index=0; 

		// 사용자의 입력을 받아들이는 클래스(객체)
		Scanner sc=new Scanner(System.in);
		
		// 프로그램이 몇회 동작하는지 정확히 모름!
		while(true)
		{
	         
			System.out.println("====================");
			System.out.println("학생부 프로그램");
			System.out.println("====================");
			System.out.println(" 1. 학생 추가"); /////
			System.out.println(" 2. 전체 출력");
			System.out.println(" 3. 학생 검색"); /////
			System.out.println(" 4. 1등 출력"); /////
			System.out.println(" 5. 정보 변경"); /////
			System.out.println(" 6. 정보 삭제"); /////
			System.out.println(" 7. 추가 기능");
			System.out.println(" 0. 프로그램 종료");
			System.out.println("====================");
			System.out.print("번호입력>> ");
	    	  
			// 사용자가 입력했던 값을 저장해야함 => 변수 필요
			int action=sc.nextInt(); 
	    	  	
			// 프로그램 종료
			// 종료조건
			if(action==0) 
			{ 
	    		  
				System.out.println();
				
				System.out.println("학생부 프로그램을 종료합니다...");
				
				System.out.println();
	            
				break;
	            
			}
			//학생 추가
			else if(action == 1) 
			{
				
				//허용 범위를 넘겨 추가 하려 하면
				if(student.length <= index) 
				{
					
					System.out.println("해당 프로그램은 " + student.length + "명까지 지원하고 있습니다.");
					
					System.out.println("곤라자에게 문의해주세요...");
					
					System.out.println();
					
					// 반복문을 멈추고 싶지는 않은데 한스텝 쉬어가고 싶을 때
					// 해당 반복문의 가장 처음으로 즉시 이동
					// break의 경우는 반복문의 바깥 쪽으로 이동
					continue;
					
				}
				
				while(true) 
				{
					
					System.out.println();
					
					System.out.println((index +1) + "번 학생을 추가합니다.");
					
					System.out.println("학생 점수 입력 >> ");
					
					//입력 값을 저장
					int score=sc.nextInt();
					
					//점수가 0~100의 범위를 넘어가면
					//유효성검사
					// : 사용자의 거의 모든 입려값에 대하여 수행하는 것이 바람직하다.
					// 목적 == 에러 최소화
					if(score >= 0 && score <= 100) 
					{
						
						//학생 수 1증가. 점수 기록
						student[index++]=score;
						
						//줄바꿈
						System.out.println(index + "번 학생 추가완료");
						
						break;
						
					}
					else 
					{
						
						System.out.println();
						
						System.out.println("점수는 0~100까지 입력 가능합니다.");
						
						System.out.println("확인 후 추가해주세요.");
						
					}
					
				}
				
			}
			//전체 출력
			else if(action==2) 
			{ 
				
				//출력할 학생 데이터가 없다면
				if(index <= 0)
				{
					
					System.out.println();
					
					System.out.println("출력할 학생 데이터가 없습니다.");
					
					System.out.println();
					
					continue;
					
				}
	        	 
				System.out.println();
				
				System.out.println("전체 출력");
				
				System.out.println();
				
				// 처음부터 "존재하는 학생"만큼 출력하기
				//          == index
				// 범위가 존재 => for문
				for(int i=0;i<index;i++) 
				{
	            	
					System.out.println((i+1)+"번 학생  "+student[i]+"점");
	               
				}
	            
				System.out.println();
	            
			}
			//학생 검색
			else if(action == 3) 
			{
				
				//검색할 학생 데이터가 없다면
				if(index <= 0) 
				{
					
					System.out.println();
					
					System.out.println("검색할 학생 데이터가 없습니다.");
					
					System.out.println();
					
					continue;
					
				}
				
				// 1)학생의 번호를 사용자가 입력
				// 2)해당 번호의 학생 점수가 출력
				System.out.println();
				
				System.out.print("검색할 학생 번호 입력>>");
				
				int stuNum = sc.nextInt();
	    		  
				if(stuNum < 1 || index < stuNum) 
				{
	    			
					System.out.println("해당 번호를 가진 학생은 존재하지 않습니다.");
	    			  
					System.out.println("확인 후 다시 이용해주세요...");
					
				}
				else 
				{
	    			
					System.out.println(stuNum + "번 학생은" + student[stuNum -1] + "점 입니다.");
	  				
					System.out.println();
	    			  
				}
				
			}
			// 1등 출력
			else if(action == 4) 
			{
				
				if(index <= 0) 
				{
					
					System.out.println();
					
					System.out.println("학생 데이터가 없습니다.");
					
					System.out.println();
					
					continue;
					
				}
				
				// 최댓값 구하기 알고리즘의 응용
				
				// 0번 인덱스를 가장 큰 값이라고 가정
				// 0번 학생이 점수가 가장 높다고 가정
				int higerStuIndex=0;
				
				// 1번부터 마지막 인덱스까지 반복
				for(int i=1;i<index;i++)
				{

					// i번 값이 가정 값 보다 크다면
					if(student[i] > student[higerStuIndex]) 
					{

						// i번 인덱스를 저장
						higerStuIndex=i;

					}
				           
				}
				
				//출력
				System.out.println((higerStuIndex + 1) + "번 학생이 " + student[higerStuIndex] + "점으로 가장 높습니다.");
				
			}
			// 정보 변경
			else if(action == 5) 
			{
				
				// 학생번호입력 >> 2
				// 2번은 현재 50점입니다.
	            // 새로운 점수를 입력 >> 51
	            // 2번 학생의 점수가 변경되었습니다.
				System.out.println();
				
				System.out.println("학생번호입력 >>");
				
				// 입력한 학생번호를 저장
				int stuNum = sc.nextInt();
				
				while(true) 
				{
				
					boolean itsOk = false;
					
					//학생번호의 유효성 체크
					if(stuNum > index) 
					{
						
						//유효성을 true로 변경
						itsOk = true;
						
					}

					//학생번호가  없다면
					if(itsOk == false) 
					{
						
						//	+)학생이 없는 경우
						//  변경할 학생 데이터가 없습니다~
						System.out.println("변경할 학생 데이터가 없습니다.");
						
						System.out.println("학생번호입력 >>");
						
						stuNum = sc.nextInt();
						
						continue;
						
					}
					//학생번호가 있다면
					else 
					{
						
						break;
						
					}
						
				}
				
				// 특정 학생의 점수를 안내
				System.out.println(stuNum + "번은 현재 " + student[stuNum -1] + "점입니다.");
				
				while(true) 
				{
						
					// 새로운 점수를 입력할 수 있도록 안내
					System.out.println("새로운 점수를 입력 >>");
						
					// 새로운 점수를 저장
					int newScore = sc.nextInt();
					
					//점수가 변경 전과 같은 경우
					if(newScore == student[stuNum -1]) 
					{
						
						System.out.println();
						
						System.out.println("점수가 같습니다.");
						
						continue;
						
					}
					//점수가 유효 범위 인경우
					else if(newScore >= 0 && newScore <= 100) 
					{
								
						// 새로운 값으로 데이터를 치환
						student[index -1] = newScore;
							
						// 변경 안내
						System.out.println(stuNum + "번 학생의 점수가 변경되었습니다.");
							
						break;
							
					}
					//점수가 유효 범위를 넘었을 경우
					else 
					{
							
						System.out.println();
						
						System.out.println("점수는 0~100까지 입력 가능합니다.");
						
						continue;
							
					}
			
				}
				
			}
			//정보 삭제
			else if(action == 6) 
			{
				
				// 배열은 추가, 삭제가 안됨
				// 배열 자체를 추가하거나 삭제할 수 없음
				// 지금은, 마지막 학생 제거로 한다.
				System.out.println();
				
				if(index<=0)
				{
				
					 System.out.println("제거할 정보가 없습니다...");
					 
					 System.out.println();
					 
					 continue;
					
				}
				
				System.out.println(index + "번 학생 정보를 제거합니다...");
				
				index--;
				
				System.out.println("제거 완료");
				
				System.out.println();
				
				
			}
			else 
			{
				
				System.out.println("");
				System.out.println("없는 기능입니다.");
				
				
			}
			
		}
		
	}

}

