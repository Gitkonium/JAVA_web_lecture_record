package class04;

//input X output O
public class Test01 
{

	public static void main(String[] args) 
	{
		
		//run -< main -> funcA ->  -> prinln -> return -> println
		System.out.println(funcA());
		
		int num = funcA();
		System.out.println(num);
		

	}
	
	public static int funcA() 
	{
		
		System.out.println("func()는 5를 반환하는 함수입니다.");
		
		//즉시 해당 함수를 종료
		return 5;
		
	}

}
