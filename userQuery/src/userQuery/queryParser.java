package userQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class queryParser {
	
	public String parse(String str, int n)
	{
		String input_string_2 = str.replaceAll("[-+.@#$%^&*()^:,;/'=!?]","");

        //Splitting the string into different words based on space between them//
		String[] input_string = input_string_2.split("\\s+");

		//Converting String Array to List to utilise list functionalities//
		List<String> list = new ArrayList<String>(Arrays.asList(input_string));
		//Removing words//

		while (list.contains("what")) {
        	list.remove("what");
    	}
    	while (list.contains("in")) {
        	list.remove("in");
    	}
    	while (list.contains("is")) {
        	list.remove("is");
    	}
    	while (list.contains("an")) {
        	list.remove("an");
    	}
    	while (list.contains("the")) {
        	list.remove("the");
    	}
    	while (list.contains("had")) {
        	list.remove("had");
    	}
    	while (list.contains("were")) {
        	list.remove("were");
    	}
    	while (list.contains("an")) {
        	list.remove("an");
    	}
    	while (list.contains("of")) {
        	list.remove("of");
    	}
    	while (list.contains("has")) {
        	list.remove("has");
    	}
    	while (list.contains("have")) {
        	list.remove("have");
    	}
    	while (list.contains("shall")) {
        	list.remove("shall");
    	}
    	while (list.contains("would")) {
        	list.remove("would");
    	}
    	while (list.contains("?")) {
        	list.remove("?");
    	}
    	while (list.contains("'")) {
        	list.remove("'");
    	}
    	while (list.contains("/")) {
        	list.remove("/");
    	}
    	while (list.contains(";")) {
        	list.remove(";");
    	}
    	while (list.contains("when")) {
        	list.remove("when");
    	}
    	while (list.contains("was")) {
        	list.remove("was");
    	}
    	while (list.contains("will")) {
        	list.remove("will");
    	}
    	while (list.contains("it")) {
        	list.remove("it");
    	}
    	while (list.contains("so")) {
        	list.remove("so");
    	}
    	while (list.contains("why")) {
        	list.remove("why");
    	}
    	while (list.contains("the")) {
        	list.remove("the");
    	}
    	while (list.contains("a")) {
        	list.remove("a");
    	}
    	while (list.contains("an")) {
        	list.remove("an");
    	}
    	while (list.contains("which")) {
        	list.remove("which");
    	}
    	while (list.contains("who")) {
        	list.remove("who");
    	}
    	while (list.contains("whose")) {
        	list.remove("whose");
    	}
    	while (list.contains("whom")) {
        	list.remove("whom");
    	}
    	//Converting back to array of strings//
		input_string = list.toArray(new String[0]);

//		System.out.println("output string: " + Arrays.toString(input_string));
		
		String base = "select * from search_engine where ";

//		System.out.println("output string: " + Arrays.toString(input_string));

		//String query = Arrays.toString(input_string);
		if(n == 0)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "lower(title) like '% "+ input_string[i] + "' or lower(title) like '" + input_string[i] + " %' or lower(title) like '% "+ input_string[i] +  " %' or ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %' or ";
			}
			base += " false";
			
//			return base;
		}
		else if(n == 1)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "lower(heading) like '% "+ input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +  " %' or ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %' or ";
			}
			base += " false";
		}
		
		else if(n == 2)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "lower(imp_words) like '% "+ input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +  " %' or ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %' or ";
			}
			base += " false";
		}
		
		else if(n == 3)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "(lower(title) like '% "+ input_string[i] + "' or lower(title) like '" + input_string[i] + " %' or lower(title) like '% "+ input_string[i] +  " %') and ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %') and ";
			}
			base += " true";
			
//			return base;
		}
		
		else if(n == 4)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "(lower(heading) like '% "+ input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +  " %') and ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %' or ";
			}
			base += " true";
		}
		else if(n == 5)
		{
			for(int i=0; i<list.size(); i++)
			{
				base += "(lower(imp_words) like '% "+ input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +  " %') and ";  
//			    		 + "or lower(heading) like '% " + input_string[i] + "' or lower(heading) like '" + input_string[i] + " %' or lower(heading) like '% "+ input_string[i] +" %' "
//			    		 + "or lower(imp_words) like '% " + input_string[i] + "' or lower(imp_words) like '" + input_string[i] + " %' or lower(imp_words) like '% "+ input_string[i] +" %' or ";
			}
			base += " true";
		}

		return base;
	}

}
