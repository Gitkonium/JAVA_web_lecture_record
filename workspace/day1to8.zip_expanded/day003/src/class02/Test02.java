package class02;

public class Test02 
{

	public static void main(String[] args) 
	{
		
		//물건이 4개있습니다.
		//각각의 상품은
		//500
		//700
		//1200
		//950원입니다.
		
		//상품의 가격을 저장하고 
		//1번 상품은 500원 입니다.
		//이렇게 출력해주세요.
		
		int[] priceArr = {500,700,1200,950};
		
		System.out.println("1번 상품은 " + priceArr[0] + "원 입니다.");
		
		//+ 1~4번 상품의 총 합 가격은 xxxx원입니다.
		
		//sum은 다른 언어에서 키워드 인 경우가 있기 때문에 잘 사용안함
		int total=0;
		
		//특정배열의 value만 궁금할 때
		//foreach문(for문)
		for(int price:priceArr) 
		{
			
			total += price;
			
		}
		
		System.out.println(total);
		
		for(int i=0;i<priceArr.length;i++) 
		{
		
			total += priceArr[i];
			
		}
		
		System.out.println(total);

	}

}
