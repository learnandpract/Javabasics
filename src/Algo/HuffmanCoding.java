package Algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MyComparator implements Comparator<HuffmanCoding>{ // NOT WORKING

	@Override
	public int compare(HuffmanCoding x, HuffmanCoding y) {
		
		return x.frequency-y.frequency;
	}
	
}

public class HuffmanCoding {
	int frequency;
    char c;
  
    HuffmanCoding left;
    HuffmanCoding right;
	
	private static void buildHuffmanTree(String text) {
		Map<Character,Integer> freq = new HashMap<>();
//		for(char c : text.toCharArray()) {
//			freq.put(c, freq.getOrDefault(c, 0)+1);
//		}
		
		freq.put('a', 5);
		freq.put('b', 9);
		freq.put('c', 12);
		freq.put('d', 13);
		freq.put('e', 16);
		freq.put('f', 45);
		
		
		//Building a tree
		PriorityQueue<HuffmanCoding> pq = new PriorityQueue<>(freq.size(),new MyComparator()); // custom comparator
		
				
			HuffmanCoding hc = new HuffmanCoding();
		//Leaf node for each char and build min heap	
			for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
				hc.c = entry.getKey();
				hc.frequency = entry.getValue();	
				hc.left = null;
		        hc.right = null;
		        pq.add(hc);
			}
		
		HuffmanCoding root = null;			
		
		//Exract two nodes with min freq from heap until size=1;
		while(pq.size()>1) {
		HuffmanCoding min1 =   pq.peek();
		pq.poll();
		
		HuffmanCoding min2 = pq.peek();
		pq.poll();
		
//		 create a new node which is sum of above 2 nodes
		HuffmanCoding newNode = new HuffmanCoding();
		newNode.frequency = min1.frequency+min2.frequency;
		newNode.c = '-';
		
		newNode.left = min1;
		newNode.right = min2;
		
		root= newNode;
		pq.add(newNode);
		
		
		}
		printCode(root, "");
		
	}

	private static void printCode(HuffmanCoding root, String s) {
		// TODO Auto-generated method stub
		
		 if (root.left == null && root.right == null && Character.isLetter(root.c)) {
	  
	            // c is the character in the node
	            System.out.println(root.c + ":" + s);
	  
	            return;
	        }
	  
	        // if we go to left then add "0" to the code.
	        // if we go to the right add"1" to the code.
	  
	        // recursive calls for left and
	        // right sub-tree of the generated tree.
	        printCode(root.left, s + "0");
	        printCode(root.right, s + "1");
	    }
		
	

	public static void main(String[] args) {
		String text = "AABCDEAA";
		buildHuffmanTree(text);

	}

	

}
