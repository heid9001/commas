package parser.commas;

import java.util.Arrays;


public class Heap {
	int[] data;
	int idx;
	int cap;
	public static int chunkSize = 8;
	
	Heap() {
		idx = 0;
		cap = chunkSize;
		data = new int[chunkSize];
	}
	
	// O(1) вставляем в кучу и сортируем
	void add(int item) {
		if(idx >= cap) {
			cap += chunkSize;
			data = Arrays.copyOf(data, cap);
		}
		data[idx] = item;
		sort();
		++idx;
	}
	
	// в худшем случае O(n), в лучшем O(1) сортировка на основе insert sort
	void sort() {
		int i = idx;
		while(i > 0) {
			int last = data[i];
			if ( last < data[i - 1] ) {
				data[i] = data[i - 1];
				data[i - 1] = last;
			} else {
				break;
			}
			--i;
		}
	}
	
	int[] getData() {
		return Arrays.copyOf(data, idx);
	}
}