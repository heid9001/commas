package parser.commas;


import java.util.regex.Pattern;

import parser.commas.exceptions.IllegalTokenException;

public class Parser {
	private String string;
	Pattern pattern;
	
	Heap heap;
	
	public Parser() {
		heap = new Heap();
		pattern = Pattern.compile("([0-9]+)");
	}
	
	public void load(String s) {
		this.string = s;
	}
	
	
	protected void validate(String token) throws IllegalTokenException {
		if (pattern.matcher(token).matches()) {
			int ibuff = Integer.parseInt(token);
			if(ibuff % 2 == 0) {
				heap.add(ibuff);
			}
		} else {
			throw new IllegalTokenException(token);
		}
	}
	
	// O(n)
	public int[] parse() throws IllegalTokenException {
		int start, end, n;
		
		start = end = 0;
		n = string.length();
		String sbuff = new String("");
		
		while(start < n && end < n) {
			if (string.charAt(end) == ';') {
				sbuff = string.substring(start, end);
				validate(sbuff);
				start = end + 1;
			} else if (end == n - 1) {
				sbuff = string.substring(start, end + 1);
				validate(sbuff);
			}
			++end;
		}
		return heap.getData();
	}
}
