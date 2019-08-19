package parser.commas;


public class Main {
	public static void main(String[] args) throws Exception{
		String input = "10;40;5";
		Parser p = new Parser();
		
		p.load(input);
		
		for(Integer i : p.parse()) {
			System.out.println(i);
		}
	}
	
	public static void what() {
		String s = "abcd";
		System.out.println(s.substring(0,1));
	}
}
