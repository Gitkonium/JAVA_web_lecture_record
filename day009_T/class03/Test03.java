package class03;

class Pokemon{
	String type;
	Pokemon(String type){
		this.type=type;
	}
	void printInfo() {
		System.out.println(this.type);
	}
}
class Pikachu extends Pokemon{
	String name;
	Pikachu(){
		this("피카츄");
	}
	Pikachu(String name){
		super("전기");
		this.name=name;
	}
}
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
