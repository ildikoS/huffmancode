/**
* The code has been implemented by this: https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
*/

import java.util.*;

class HuffmanCode{

    public static void printCode(Node root, String code, Map<Character, String> huffmanCode) { 
  
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code); 
            huffmanCode.put(root.ch,code);
  
            return; 
        } 

        printCode(root.left, code + "0", huffmanCode); 
        printCode(root.right, code + "1", huffmanCode); 
    }

    public static void main(String[] args) {
        System.out.println("Kerem irjon be egy szoveget");
        String input = System.console().readLine();

        ArrayList<Character> listOfChar = new ArrayList<Character>();
        ArrayList<Integer> listOfFreqs = new ArrayList<Integer>();

        for (char c : input.toCharArray()){
            if(!listOfChar.contains(c)) listOfChar.add(c);
        }

        int n = listOfChar.size();
        for(int i=0; i<n; i++){
            int counter = 0;
            for (char a : input.toCharArray()){
                if (listOfChar.get(i) == a) counter++;
            }
            listOfFreqs.add(counter);
        }
        
        //Test
        System.out.println(listOfChar);
        System.out.println(listOfFreqs);

        PriorityQueue<Node> pQ = new PriorityQueue<Node>(n, new MyComparator()); 
  
        for (int i = 0; i < n; i++) { 
            Node node = new Node(); 
  
            node.ch = listOfChar.get(i); 
            node.freq = listOfFreqs.get(i); 
  
            node.left = null; 
            node.right = null; 

            pQ.add(node); 
        }

        Node root = null; 

        while (pQ.size() != 1) { 
  
            Node first = pQ.peek(); 
            pQ.poll(); 
  
            Node second = pQ.peek(); 
            pQ.poll(); 
  
            Node f = new Node(); 

            f.freq = first.freq + second.freq; 
            f.ch = '-'; 

            f.left = first; 
            f.right = second; 

            root = f; 

            pQ.add(f); 
        } 

        Map<Character, String> huffmanCode = new HashMap<>();
        System.out.println("--------------\nA kodtabla: ");
        printCode(root, "", huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (char e : input.toCharArray()){
            sb.append(huffmanCode.get(e));
        }
        System.out.println("--------------\nA szoveg kodolt formaja: " + sb);
    }
}

class Node { 
    int freq; 
    char ch; 
  
    Node left, right; 
} 

class MyComparator implements Comparator<Node> { 
    public int compare(Node first, Node second) 
    {
        return first.freq - second.freq; 
    } 
} 