package parser.commas;



import org.junit.Assert;

import junit.framework.TestCase;
import parser.commas.exceptions.IllegalTokenException;


public class ParserTest 
    extends TestCase
{
	
	InputFixture[] fixtures;
	Parser parser;
	
	class InputFixture {
		String in;
		int[] value;
		int[] actual;
		boolean expected;
		
		InputFixture(String in, boolean expected) {
			this.in = in;
			this.expected = expected;
		}
		
		InputFixture(String in, boolean expected, int[] actual) {
			this.in = in;
			this.expected = expected;
			this.actual = actual;
		}
	}
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		fixtures = new InputFixture[] {
			new InputFixture(";", false),
			new InputFixture(";;", false),
			new InputFixture(";0", false),
			new InputFixture("", true, new int[] {}),
			new InputFixture("0;", true, new int[] {0}),
			new InputFixture("10;40;5", true, new int[] {10, 40}),
			new InputFixture("15;5;", true, new int[] {}),
			new InputFixture("1024;102;55;77;128;56", true, new int[] {56, 102, 128, 1024})
		};
		
	}
	
	public void testParser() {
		for( InputFixture fixture: fixtures) {
			parser = new Parser();
			parser.load(fixture.in);
			try {
				fixture.value = parser.parse();
				assertEquals(fixture.expected, true);
				System.out.println(fixture.in);
				Assert.assertArrayEquals(fixture.actual, fixture.value);
			} catch (IllegalTokenException e) {
				assertEquals(fixture.expected, false);
			}
		}
	}
}
