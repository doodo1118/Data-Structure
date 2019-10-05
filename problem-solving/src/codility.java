import java.util.*;
import java.io.*;

class codility {
	public static void main(String[] args) throws IOException {
		
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = bf.readLine().split("-");
    	
    	int sum=0;
    	
    	
    	if(str.length==1) {
    		sum = calcAddFormula(str[0]);
    	}else {
   
    		int i=0;
        	for(String el:str) {
        		if(i==0) {
        			sum += calcAddFormula(el);
        			i++;
        		}else {
        			sum -= calcAddFormula(el);
        		}
        	}
    	}
    	
    	System.out.print(sum);
	}
	
	public static int calcAddFormula(String str) {
		int sum=0;
		String[] subStr = str.split("\\+");
		for(String subEl:subStr) {
			sum += Integer.parseInt(subEl);
		}
		return sum;
	}
}
