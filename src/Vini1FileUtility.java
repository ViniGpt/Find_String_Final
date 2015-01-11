import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
/*import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Vini1FileUtility implements IFileUtility{
	InputFields inputFields=null;
	public Vini1FileUtility(InputFields inputFields)
	{
		this.inputFields=inputFields;
	}
	@Override
	public void SimplePatternSearch() {
		SimplePatternSearchHelper();
	}
    private Pattern getPattern(String pat,case_attr caseAttr)
    { Pattern pattern=null;
    	 
    	try {
			if (caseAttr == case_attr.CASE_INSENSITIVE)
				pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
			else
				pattern = Pattern.compile(pat);
		    }
		catch (PatternSyntaxException x) {
			System.err.println(x.getMessage());
		}
    	return pattern;
    }
	private void SimplePatternSearchHelper() {
		Pattern pattern=null;
		Matcher m;
		BufferedReader reader = null;
		int count = 0, sl = 0;
		String line = null;
		pattern=getPattern(inputFields.Pat,inputFields.caseAttr);
		try {
		reader = new BufferedReader(new FileReader(inputFields.FileName));
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		System.out.println("filename::serial no::LineNo::LineText");
		try {
			while ((line = reader.readLine()) != null) {
				count++;
				m = pattern.matcher(line);
				if (m.find()) {
					sl++;
					System.out.println(inputFields.FileName.getName()+"::"+sl + "::" + count + "::" + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total found: " + sl + ",number of lines: " + count);

		
	}
	

	

	
	/*public void RemoveDuplicateLines(String filename, String outputFileName) {
	HashMap<String, Integer> m= new HashMap<String, Integer>();
	String line=null;
	Iterator it;
	Map.Entry pairs;
	int val=0;
	File inputfile=null,outputfile=null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	try {
		 reader = new BufferedReader(new FileReader(new File(filename)));
		 writer = new BufferedWriter(new FileWriter(new File(outputFileName)));
		while ((line = reader.readLine()) != null)
		{
			if(!m.containsKey(line))
			{
				writer.write(line);
				writer.newLine();
				m.put(line, 1);
			} 
			else
			{   val=m.get(line);
				m.replace(line,val,val+1);
			}
		}
		
		reader.close();
		writer.close();
		m=sortByValues(m);
	it = m.entrySet().iterator();
	    while (it.hasNext()) {
	        pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
					
		
		
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
*/	
	/*private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	        public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o2)).getValue())
	                  .compareTo(((Map.Entry) (o1)).getValue());
	            }
	       });
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	}	*/
		

}

	

