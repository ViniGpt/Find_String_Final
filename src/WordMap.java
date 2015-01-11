import java.util.HashMap;
import java.util.Map.Entry;

public class WordMap
{
	HashMap<String, Integer> m;
	public WordMap()
	{ m= new HashMap<String, Integer>();
	}

	public void add(String s)
	{   int freq=0;		
	    if(m.containsKey(s)) { 
	    	freq=m.get(s);
	        m.replace(s,freq , freq+1);
	    }
	    else 
	    	m.put(s, freq+1);
	}
	public void display()
	{   
		for (Entry<String, Integer> entry : m.entrySet()) {
		    System.out.println(entry.getKey()+"::"+entry.getValue());		   
		}
	}
}