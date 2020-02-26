package sr_test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class sr_tests {
	
	private static sr_test_gui myGui;
	public static List<String> strng;
	public static List<String> stack2;
	public static List<String> stack3;
	public static boolean[] visitedStr = new boolean[100];
	public static String plus = "+";
	public static String conc = ".";
	public static String star = "*";
	
	
	//public static String[] str = {"a",".","(","b",".","(","c","+","d",")",")"};

	//public static String[] str = {"(","a","+","b","+","c","+","d","+","e","+","f","+","g","+","h",")",".","(","u","+","v","+","y",")","*","(","z","+","t","+","k","+","m",")"};
	
	//public static String[] str = {"(","a","+","b","+","c","+","d","+","(","x","+","y","+","w",")","*","+","f","+","g","+","h",")",".","(","u","+","v","+","y",")","*","(","z","+","t","+","k","+","m",")"};
	
	//public static String[] str = {"(","a","+","b","+","c","+","d","+","(","x","+","(","i","+","j","+","k",")","*","+","w",")","*","+","f","+","g","+","h",")",".","(","u","+","v","+","y",")","*","(","z","+","t","+","k","+","m",")"};
	
	public static void main(String[] args) {
		
		sr_tests R_Ex = new sr_tests();
		myGui = new sr_test_gui();
		myGui.set_RE(R_Ex);
		myGui.setVisible(true);
		strng = new ArrayList<String>();
		stack2 = new ArrayList<String>();
		stack3 = new ArrayList<String>();
		
	}
	
	public static void SR_Test(List <String> str) {
		
		int index = 0;
		initVisitedFlag();
		ListIterator<String> iterator = str.listIterator();
		stack2.clear();
		stack3.clear();
		
		while(iterator.hasNext()) {
			if(index <str.size()) {
				if (str.get(index).equals(plus)) {
					
					if(str.get(index-1).equals(")") ) {
						if(str.get(index+1).equals("(") ) {
							index =index+1;
						}else {
							visitedStr[index] = true;
							index =index+1;	
						}
					}else if(str.get(index+1).equals("(") ) {
						if(str.get(index+1).equals(")") ) {
							
						}else {
							
							stack3.add(str.get(index-1));
							stack2.add(str.get(index+1));
							visitedStr[index] = true;;
							index =index+1;	
						}
						
					}else {
						int a = index-1;
						
						if(visitedStr[a] == true) {

						}else {
							
							stack2.add(str.get(index-1));
							stack3.add(str.get(index+1));
							visitedStr[index+1] = true;
						}
						
						
						visitedStr[index] = true;
						index =index+1;
					}
					
				}else if(str.get(index).equals(conc)) {
					if(str.get(index-1).equals(star) ) {
						if(str.get(index-1).equals("(")) {
						
						}else {
							
							stack3.add(str.get(index-2));
							stack3.add(str.get(index+1));
							stack2.add(str.get(index-2));
							stack2.add(str.get(index+1));
							visitedStr[index] = true;;
							index =index+1;	
						}
						
					}else if(str.get(index+1).equals(star) ) {
						
						stack3.add(str.get(index-1));
						stack3.add(str.get(index+2));
						stack2.add(str.get(index-1));
						stack2.add(str.get(index+2));
						visitedStr[index] = true;;
						index =index+1;	
					}else if(str.get(index-1).equals(")") ) {
						if(str.get(index+1).equals("(")) {
							index =index+1;	
						}else {
							int a = index-1;
							
							if(visitedStr[a] == true) {

							}else {
								
								stack3.add(str.get(index+1));
								stack2.add(str.get(index+1));
								visitedStr[index+1] = true;
							}
							
							visitedStr[index] = true;;
							index =index+1;	
						}
					}else if(str.get(index+1).equals("(")) {
						if(str.get(index-1).equals(")")) {
							
						}else {
							int a = index-1;
							
							if(visitedStr[a] == true) {

							}else {
								
								stack3.add(str.get(index-1));
								stack2.add(str.get(index-1));
								visitedStr[index+1] = true;
							}
							visitedStr[index] = true;;
							index =index+1;	
						}
						
					}else {
						int a = index-1;
						
						if(visitedStr[a] == true) {
							
							
							stack3.add(str.get(index+1));
							
							stack2.add(str.get(index+1));
							
							visitedStr[index+1] = true;
						}else {
							
							stack3.add(str.get(index-1));
							stack3.add(str.get(index+1));
							
							stack2.add(str.get(index-1));
							stack2.add(str.get(index+1));
							
							visitedStr[index+1] = true;
						}
						
						visitedStr[index] = true;
						index =index+1;
					}
					
				}else if(str.get(index).equals(star)) {
					if(str.get(index-1).equals(")" )) {
						
						stack3.add(str.get(index-2));
						stack2.add(str.get(index-4));
						visitedStr[index] = true;;
						index =index+1;	
						}else {
						
						stack3.add(str.get(index-1));
						stack2.add(str.get(index-1));
						visitedStr[index] = true;
						index =index+1;
					}
				}
				else {
					index = index+1;
				}
					
			} else {
				break;
			}
			
		}
		str.clear();
		
		
	}

	public static void initVisitedFlag() {
		for(int i=0;i<visitedStr.length;i++) {
			visitedStr[i] = false;
		}
	}
	
	public void create_test_case(String Re) {
		
        for (int i = 0; i < Re.length(); i++) {
        	String a = Re.substring(i, i+1);
        	strng.add(a);
		}
        SR_Test(strng);
        myGui.log_RE.append(stack2.toString()+"\n");
        myGui.log_RE.append(stack3.toString()+"\n");
    }

	public void exit() {
	    	
	    	System.exit(0);
	    }

}

