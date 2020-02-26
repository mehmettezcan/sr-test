package sr_test_selenium;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class parse_iselta {
	public static void main(String[] args) throws IOException {
		    parse_iselta parse_txt = new parse_iselta("C:\\Users\\Tezcan\\Desktop\\mt_RE.txt");
		    parse_txt.processLineByLine();
		    log("Fin!");
		  }
	 public parse_iselta(String aFName){
		    fPth = Paths.get(aFName);
		  }
	public final void processLineByLine() throws IOException {
		
		 
		    try (Scanner scan =  new Scanner(fPth, ENCODE.name())){
		    	FileWriter writer = new FileWriter("C:\\Users\\Tezcan\\Desktop\\mt_RE_parsed.txt",true);
		    	//List<String> Array = new ArrayList<String>();
		    	
		    	while (scan.hasNextLine()){
		    	  String doc = scan.nextLine();
		    	  String a= doc.replaceAll("\\[","");
	    		  String b = a.replaceAll("\\]","\n");
	    		  String c = b.replaceAll(", ","\n");
	    		  writer.write(c);
		      }
		    	//FileWriter writer = new FileWriter("C:\\Users\\Mehmet Tezcan\\Desktop\\abc.txt",true);
		    	//String S = Array.get(0);
		    	//String s = S.
	    		  //System.out.println(s);
	    		 
	    		  //System.out.println(Array);

  	               // writer.write(document);
  	               writer.close();
  	                }}
		  
		  private final Path fPth;
		  private final static Charset ENCODE = StandardCharsets.UTF_8;  
		  
		  private static void log(Object Obj){
		    System.out.println(Objects.toString(Obj));
		  }

		}
