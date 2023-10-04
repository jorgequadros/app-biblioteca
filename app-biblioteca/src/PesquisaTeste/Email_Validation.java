package PesquisaTeste;

	import java.util.regex.*;
	import java.util.*;
	public class Email_Validation{
	    public static void main(String args[]){
	        ArrayList<String> email = new ArrayList<String>();
	        email.add("example@domain.com.br");
	        //Adding an invalid emails in list  
	        email.add("@helloworld.com");
	        //Regular Expression   
	        String regx = "^(.+)@(.+)$";
	        //Compile regular expression to get the pattern  
	        Pattern pattern = Pattern.compile(regx);
	        //Iterate emails array list  
	        for(String email1 : email){
	            //Create instance of matcher   
	            Matcher matcher = pattern.matcher(email1);
	            System.out.println(email1 +" : "+ matcher.matches()+"\n");
	        }
	    }
	}

