package class04;

class Animal {
	String type;
	String name;
	Animal(String type){
		this(type,"이름없는 "+type);
	}
	Animal(String type,String name){
		this.type=type;
		this.name=name;
	}
	void printInfo() {
		System.out.println(this.type+" : "+this.name);
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		Animal a1=new Animal("강아지","초코");
		Animal a2=new Animal("고양이");
		
		a1.printInfo();
		a2.printInfo();
		
	}

}
