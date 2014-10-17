package com.duplicate.elements;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Anil
 * Description:Write a java program to search duplicate words in a
   string using regular expression.
 */

public class DuplicateElementDemo {
    public static void main (String args[]) {
  //  String input="This This is text text another another";
    Scanner input=new Scanner(System.in);
    System.out.println("Enter The Text");
    String originalText = input.nextLine();
    System.out.println(originalText);
    String output = "";

    Pattern p = Pattern.compile("\\b(\\w+)\\b\\s+\\b\\1\\b", Pattern.MULTILINE+Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(originalText);
    Matcher m1=p.matcher(originalText);
   
    while (m1.find()) {
    	String  val = m1.group();
    	System.out.println("Matching Sequence is \"" + val + "\"");
    	System.out.println("Searched Duplicate Word: " + m1.group(1) + "\n");
		
	}
    
    if (!m.find())
       output="No Duplicate Data";
    else
    {
    	
    	  
        while (m.find())
        {
          
        	if (output == "") {
                output = originalText.replaceFirst(m.group(), m.group(1));
               
            } else {
                output = output.replaceAll(m.group(), m.group(1));
            }
           
        }
        originalText=output;
        m = p.matcher(originalText);
        while (m.find())
        {
        	
            output = "";
            // System.out.println("\n\nStart loop again\n" + m.group(0) + " : " + m.group(1) + "\nEnd Group" + m.groupCount() + "\n");
            // System.out.println("Second Pass");
            if (output == "") {
                output = originalText.replaceAll(m.group(), m.group(1));
            } else {
                output = output.replaceAll(m.group(), m.group(1));
            }
        }
      
    }
    System.out.println("Removing duplicate  Values : " +output);
    
    
}
    
}