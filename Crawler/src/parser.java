import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class parser {

	public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }
	
	public String stringParser(String str)
	{
		int MAX_WORDS = 5;
//		System.out.println("input string - " + str);
		String input_string_2 = str.replaceAll("[-+.<>@#$%^&*()^:,;/'=!?]","").toLowerCase();
		
//		String temp1 = str.replaceAll("<", "");
//		String temp2 = temp1.replaceAll(">", "");
//        String temp3 = temp2.replaceAll("<", "");
//        String temp4 = temp3.replaceAll(">", "");
//        String temp5 = temp4.replaceAll("-", "");
//        String input_string_2 = temp5.replaceAll(".", "");
//        System.out.println("input string - " + input_string_2);
//        input_string_2 = input_string_2.replaceAll("[", "");
//        input_string_2 = input_string_2.replaceAll("]", "");
//        input_string_2 = input_string_2.replaceAll("{", "");
//        input_string_2 = input_string_2.replaceAll("}", "");
//        input_string_2 = input_string_2.replaceAll("(", "");
//        input_string_2 = input_string_2.replaceAll(")", "");
        //Splitting the string into different words based on space between them//
		String[] input_string = input_string_2.split("\\s+");

		//Converting String Array to List to utilise list functionalities//
		List<String> list = new ArrayList<String>(Arrays.asList(input_string));
		//Removing words//

		while (list.contains("what")) {
        	list.remove("what");
    	}
		while (list.contains("how")) {
        	list.remove("how");
    	}
		while (list.contains("by")) {
        	list.remove("by");
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
    	while (list.contains("at")) {
        	list.remove("at");
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
    	while (list.contains("and")) {
        	list.remove("and");
    	}
    	while (list.contains("for")) {
        	list.remove("for");
    	}
    	while (list.contains("to")) {
        	list.remove("to");
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
    	while (list.contains("from")) {
        	list.remove("from");
    	}
    	while (list.contains("can")) {
        	list.remove("can");
    	}
    	while (list.contains("how")) {
        	list.remove("how");
    	}
    	while (list.contains("should")) {
        	list.remove("should");
    	}
    	while (list.contains("how")) {
        	list.remove("how");
    	}
    	while (list.contains("could")) {
        	list.remove("could");
    	}
    

    	//Converting back to array of strings//
		input_string = list.toArray(new String[0]);

//		String base = "select * from search_engine where ";

//		System.out.println("output string: " + Arrays.toString(input_string));
		
//		return Arrays.toString(input_string);
		//String query = Arrays.toString(input_string);
//		for(int i=0; i<list.size(); i++)
//		{
//			base += "title like '% "+ input_string[i] + "' or title like '" + input_string[i] + " %' or title like '% "+ input_string[i] +  " %' "  
//		    		 + "or heading like '% " + input_string[i] + "' or heading like '" + input_string[i] + " %' or heading like '% "+ input_string[i] +" %' and ";
//		}
//		base += " true";
//
//		System.out.println("Final string " + base);
		String Str = Arrays.toString(input_string);
		
		System.out.println(Str);
		int len = Str.length();

		String parsedSentence = Str.substring(1, len-1).replaceAll(",", "");
		
		String[] words = parsedSentence.split(" ");
		Map<String, Integer> map = new HashMap<>();

		for (String w : words)
		{
			Integer n = map.get(w);
			if(n == null)
			{
				n = 1;
			}
			else
			{
				n++;
			}
			map.put(w,n);
		}
		
		String ret = "";
		int counter = 0;
		Map<String, Integer> sortedMap = sortByValue(map);
		
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
		{
			if(counter >= MAX_WORDS)
				break;
//			System.out.println("Key = "+ entry.getKey() + ", Value = " + entry.getValue());
			ret += entry.getKey() + " " + entry.getValue() + " ";
			counter ++;
		}
		
		return ret;
	}
}
