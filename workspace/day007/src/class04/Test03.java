package class04;

class Pokemon{
	int lv;
	int exp;
	String name;
	void hello() {
		System.out.println(name+" Lv."+lv+" ["+exp+"/100]");
	}
}
class Dog{
	String name;
	String type;
	void printInfo() {
		System.out.println(name+"(이)는 "+type+"입니다~~!");
	}
}

public class Test03 {

	public static void main(String[] args) {

		Pokemon p1=new Pokemon();
		p1.lv=5;
		p1.exp=0;
		p1.name="피카츄";
		Pokemon p2=new Pokemon();
		p2.lv=6;
		p2.exp=20;
		p2.name="꼬부기";
		
		Dog d1=new Dog();
		d1.name="용용이";
		d1.type="푸들";
		Dog d2=new Dog();
		d2.name="구동이";
		d2.type="시츄";
		
		p1.hello();
		p2.hello();
		d1.printInfo();
		d2.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
