import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class WordFrequency {
	
  private static final CalculateFrequency[] ListOfThreads = new CalculateFrequency[10];

public static void main(String[] args) {
	   WordMap wm= new WordMap();
	   Scanner s= new Scanner(System.in);
		 System.out.println("Enter folder path: ");
		 String folderPath=s.nextLine();
		 s.close();
		 File folder = new File(folderPath);
		 File[] listOfFiles = folder.listFiles();
		    for (int i = 0,j=0; i < listOfFiles.length; i++) {
		       if (listOfFiles[i].isFile()) {
		    	   System.out.println("File " + listOfFiles[i].getName());
		    	   ListOfThreads[j] = new CalculateFrequency(listOfFiles[i]);
		    	   ListOfThreads[j].start();
		    	   j++;
		    	} 
		     }
		    wm.display();
	  }
	}

class CalculateFrequency extends Thread
{  File filename;
   WordMap m;
	public CalculateFrequency(File filename)
	{
		super();
		this.filename=filename;
		this.m= new WordMap();
	}
public void run()
{  Scanner scanInput=null;
	try {
		scanInput = new Scanner(new FileReader(filename));
		scanInput.useDelimiter("[^a-zA-Z0-9\\-\']+");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	while (scanInput.hasNext()) {
			String next = scanInput.next();
			m.add(next);
			}
	scanInput.close();
	m.display();
		
	}
}

