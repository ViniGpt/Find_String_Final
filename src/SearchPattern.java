import java.io.File;
import java.util.Scanner;

class Search_File extends Thread
{    InputFields inputFields=null;
    
	public Search_File(File file_to_search,String search_pattern)
	{
	super();
	inputFields = new InputFields(file_to_search,search_pattern,case_attr.CASE_SENSITIVE);
	}
	public void run()
	{   
		IFileUtility inst= new Vini1FileUtility(inputFields);
		inst.SimplePatternSearch();
	}
	
	}
public class SearchPattern {
	
	static Search_File[] ListOfThreads=new Search_File[10];
 
	public static void main (String args[])
	{
	 Scanner s= new Scanner(System.in);
	 System.out.println("Enter folder path: ");
	 String folderPath=s.nextLine();
	 System.out.println("Enter Pattern to search: ");
	 String search_pattern=s.nextLine();
	 s.close();
	 File folder = new File(folderPath);
	 File[] listOfFiles = folder.listFiles();
	    for (int i = 0,j=0; i < listOfFiles.length; i++) {
	       if (listOfFiles[i].isFile()) {
	    	   System.out.println("File " + listOfFiles[i].getName());
	    	   ListOfThreads[j] = new Search_File(listOfFiles[i],search_pattern);
	    	   ListOfThreads[j].start();
	    	   j++;
	    	} 
	     }
	     
	  
	 
	}

}

