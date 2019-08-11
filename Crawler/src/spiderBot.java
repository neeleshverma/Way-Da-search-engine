//package Crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spiderBot {
	private static int maxPages = 10000;
	private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    private List<String> baseUrls = new LinkedList<String>();
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    
    
    public void initializeBaseUrl() {
//    	this.baseUrls.add("https://www.cse.iitb.ac.in/cse-cacert.pem");
    	this.baseUrls.add("http://www.iitb.ac.in");
    	this.baseUrls.add("http://www.cse.iitb.ac.in");
    	this.baseUrls.add("https://www.postgresql.org/");
    	this.baseUrls.add("https://www.udemy.com");
    	this.baseUrls.add("https://www.tutorialspoint.com");
    	this.baseUrls.add("https://www.geeksforgeeks.org/");
    	

//    	this.baseUrls.add("https://www.youtube.com/");
    }
    
    public static boolean isValid(String url) 
    { 
        /* Try creating a valid URL */
        try { 
            new URL(url).toURI(); 
            return true; 
        } 
          
        // If there was an Exception 
        // while creating URL object 
        catch (Exception e) { 
            return false; 
        } 
    }
    
    public void getUrls() throws NullPointerException{
    	
    	//////////////////////////////////File creation/////////////////////////////////////////////////////////////
    	String filePath = "/home/neelesh/Desktop/crawlOutput.txt";
        
        Writer bufferedWriter = null;
        
        try 
        {
        	Writer fileWriter = new FileWriter(filePath);
        	bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch(IOException ioe)
        {
        	System.out.println("File couldn't be created");
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    	for(int i=0; i<baseUrls.size(); i++)
    	{
    		pagesToVisit.add(baseUrls.get(i));
    	}
    	int pagesNo = 0;
    	int pagesToVisitSize = pagesToVisit.size();
    	
    	/////////////////////////////////////////////////////Crawling starts////////////////////////////////////////
    	while(pagesNo < maxPages)
    	{
    		String visitingUrl =  pagesToVisit.get(pagesNo);
    		//System.out.println(visitingUrl);
    		if(!(pagesVisited.contains(visitingUrl)) && isValid(visitingUrl))
    		{
    			pagesVisited.add(visitingUrl);
    			try
    			{	System.out.println(visitingUrl);
    				Connection conn = Jsoup.connect(visitingUrl).userAgent(USER_AGENT);
    				Document htmlFile = conn.get();
    				if(conn.response().statusCode() == 200)
    				{
    					System.out.println("Web page visiting - " + visitingUrl);
    					//System.out.println("Title");
    					String title = htmlFile.title();
    					System.out.println(title);
    					/////////////////////////////////////Printing Contents in file/////////////////////////////////////////////////////////////
    					//bufferedWriter.write(visitingUrl + "		" + title);
    					//bufferedWriter.write(System.getProperty("line.separator"));
    					//////////////////////////////////////////////////////////////////////////////////////////////////
    					//////////////////////////////// Getting words list //////////////////////////////////////////////
    					String heading1 = "";
    					
    					while(true)
    					{
    						try
        					{
        						if(!htmlFile.body().getElementsByTag("h1").text().equals(null))
            					{
        							heading1 = htmlFile.body().getElementsByTag("h1").text();
            					}
            					break;
        					}
        					catch(NullPointerException e) 
        			        { 
        			            System.out.print("Here is NullPointerException Caught"); 
        			            break;
        			        }
    					}
    					
    					String heading2 = "";
    					
    					while(true)
    					{
    						try
        					{
        						if(!htmlFile.body().getElementsByTag("h2").text().equals(null))
            					{
        							heading2 = htmlFile.body().getElementsByTag("h2").text();
            					}
            					break;
        					}
        					catch(NullPointerException e) 
        			        { 
        			            System.out.print("Here is NullPointerException Caught"); 
        			            break;
        			        }
    					}
    					
    					String heading3 = "";
    					
    					while(true)
    					{
    						try
        					{
        						if(!htmlFile.body().getElementsByTag("h3").text().equals(null))
            					{
        							heading2 = htmlFile.body().getElementsByTag("h3").text();
            					}
            					break;
        					}
        					catch(NullPointerException e) 
        			        { 
        			            System.out.print("Here is NullPointerException Caught"); 
        			            break;
        			        }
    					}
    					
    					String heading4 = "";
    					
    					while(true)
    					{
    						try
        					{
        						if(!htmlFile.body().getElementsByTag("h4").text().equals(null))
            					{
        							heading2 = htmlFile.body().getElementsByTag("h4").text();
            					}
            					break;
        					}
        					catch(NullPointerException e) 
        			        { 
        			            System.out.print("Here is NullPointerException Caught"); 
        			            break;
        			        }
    					}
    			
//    					String heading1 = htmlFile.body().getElementsByTag("h1").text();
//    					String heading2 = htmlFile.body().getElementsByTag("h2").text();
//    					String heading3 = htmlFile.body().getElementsByTag("h3").text();
//    					String heading4 = htmlFile.body().getElementsByTag("h4").text();
//    					String heading5 = htmlFile.body().getElementsByTag("h5").text();
//    					String heading6 = htmlFile.body().getElementsByTag("h6").text();
//    					String description = htmlFile.select("meta[name=description]").get(0).attr("content");
//    					System.out.println("heading2 - " + heading2);
//    					String keywords = htmlFile.select("meta[name=keywords]").first().attr("content");
    					
    					String description = "";
    					String keywords = "";
    					
    					while(true)
    					{
    						try
    						{
    							if(!htmlFile.select("meta[name=keywords]").first().equals(null))
    	    					{
    	    						description = htmlFile.select("meta[name=keywords]").first().attr("content");
    	    					}
    							break;
    						}
    						catch(NullPointerException e) 
        			        { 
        			            System.out.println("Here is another NullPointerException Caught"); 
        			            break;
        			        }
    						
    					}
    					
    					while(true)
    					{
    						try
    						{
    							if(!htmlFile.select("meta[name=description]").first().equals(null))
    	    					{
    	    						description = htmlFile.select("meta[name=description]").first().attr("content");
    	    					}
    							break;
    						}
    						catch(NullPointerException e) 
        			        { 
        			            System.out.println("Here is another NullPointerException Caught"); 
        			            break;
        			        }
    						
    					}
    					
//    					System.out.println("keywords - " + keywords);
//    					System.out.println("Description - "+ description);
    					String headings = heading2 + heading3 + heading4 + keywords + description;
    					
//    					System.out.println("headings - " + headings);
    					parser Parser = new parser();
    					String parsedHeading = Parser.stringParser(headings);
    					
//    					System.out.println(parsedHeading);
    					//String arr[] = null;
//    					String[] split = headings.split(" ");
//    					int size = split.length;
//    					String temp = null;
//    					
//    					for(int i=0; i<size; i++)
//    					{
//    						for(int j=i+1; j<size; j++)
//    						{
//    							if(split[i].compareTo(split[j])>0)
//    							{
//    								temp = split[i];
//    								split[i] = split[j];
//    								split[j] = temp;
//    								
//    							}
//    						}
//    					}
//    					
//    					HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
//    					
//    					int countArr[] = null;
//    					int countArrIndex = 0;
//    					for(int i=0; i<size; i++)
//    					{
//    						String str = split[i];
//    						int j = i;
//    						int count = 0;
//    						while(split[j].equals(split[i]))
//    						{
//    							j++;
//    							count++;
//    						}
//    						countArr[countArrIndex] = count;
//    						countArrIndex++;
//    						wordCount.put(split[i], count);
//    						i = j;
//    					}
//    					
//    					Arrays.sort(countArr);
//    					
//    					String[] relevant = null;
//    					
//    					for(int i=0; i<wordCount.size(); i++)
//    					{
//    						if(wordCount.getValue())
//    					}
    					
//    					Comparator<Entry<String, I>> valueComparator = new Comparator<Entry<String,String>>() {
//    			            
//    			            @Override
//    			            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
//    			                String v1 = e1.getValue();
//    			                String v2 = e2.getValue();
//    			                return v2.compareTo(v1);
//    			            }
//    			        };
    					
    					//////////////////////////////////////////////////////////////////////////////////////////////////
    					bufferedWriter.write(visitingUrl + "----" + title + "----" + heading1 + "----" + parsedHeading);
    					bufferedWriter.write(System.getProperty("line.separator"));
    				}
    				try
    				{
    					if(!conn.response().contentType().contains("text/html"))
        				{
        					System.out.println("Retrieved something other than html");
        				}
    				}
    				catch(NullPointerException e) 
			        { 
			            System.out.print("Here is NullPointerException Caught"); 
			            continue;
			        }
    				
    				
    				Elements linksFound = htmlFile.select("a[href]");
    				//System.out.println("Found urls - " + linksFound.size());
    				
    				int maxUrls = 30;
    				int counter = 0;
    				for(Element links : linksFound)
    				{
    					if(counter >= maxUrls)
    						break;
    					pagesToVisit.add(pagesToVisitSize - 1, links.absUrl("href"));
    					pagesToVisitSize ++;
    					counter++;
    				}
    			}
    			catch(IOException ie)
    			{
    				System.out.println("Oops! Some Error occurred in " + visitingUrl);
    			}
    			
    		}
    		pagesNo++;
    	}
    	
    	if(bufferedWriter != null)
    	{
    		try {
    			bufferedWriter.close();
    		}
    		catch(IOException e) {
    			System.out.println("Couldn't close the file");
    			e.printStackTrace();
    		}
    	}
    }
    
    public static void main(String args[])
    {
    	//System.out.println("Hello");
    	
    	
    	spiderBot spider = new spiderBot();
    	spider.initializeBaseUrl();
    	//System.out.println("Hello");
    	spider.getUrls();
//    	System.out.println(spider.pagesVisited);
    }
}
