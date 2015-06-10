package hockey.icescore.helper;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConfigLoader {


	
	private static LinkedHashMap<String,String> tempHash = new LinkedHashMap<String,String>();
	private static LinkedHashMap<String, LinkedHashMap<String,String>> content;
	
	private static void read(File file) throws FileNotFoundException
	{
		Scanner reader = new Scanner(file);
		content = new LinkedHashMap<String, LinkedHashMap<String,String>>();
	
		String tempSection = "";
		ArrayList<String> lines = new ArrayList<String>();
		
			while(reader.hasNext())
				lines.add(reader.nextLine());
			reader.close();
			
		for(String line:lines)
		{
			if(line.isEmpty())
				add(tempSection);
			if(line.contains(";"))
				line = line.subSequence(0, line.indexOf(";")).toString();
			if(line.contains("[")&&line.contains("]"))
				tempSection = line;
			if( !line.isEmpty()&&!line.contains("["))
				seperateKey(line);

		}
		
	}
    private static void readStrings(String[] s) throws FileNotFoundException
    {

        content = new LinkedHashMap<String, LinkedHashMap<String,String>>();

        String tempSection = "";
        ArrayList<String> lines = new ArrayList<String>();

       for(String t:s) {
           lines.add(t);
       }

        for(String line:lines)
        {

                if (line.isEmpty()||line.contains("#221155#"))
                    add(tempSection);
                if (line.contains(";"))
                    line = line.subSequence(0, line.indexOf(";")).toString();
                if (line.contains("[") && line.contains("]"))
                    tempSection = line;
                if (!line.isEmpty() && !line.contains("["))
                    seperateKey(line);

        }

    }
	
	public static  LinkedHashMap<String, LinkedHashMap<String,String>> returnLinkedHashMap(File file) throws FileNotFoundException
	{
		read(file);
		return content;
	}
	
	public static  ConfigContent returnConfigContent(File file) throws FileNotFoundException
	{
		read(file);
		ConfigContent cfgContent = new ConfigContent(content);
		return cfgContent;
	}

    public static  LinkedHashMap<String, LinkedHashMap<String,String>> returnLinkedHashMapFromStrings(String[] s) throws FileNotFoundException
    {

        readStrings(s);
        return content;
    }

    public static  ConfigContent returnConfigContentFromStrings(String[] s) throws FileNotFoundException
    {

        readStrings(s);
        ConfigContent cfgContent = new ConfigContent(content);
        return cfgContent;
    }
	
	private static void seperateKey(String line){
		
		String key,value,keyValPair[];
		keyValPair = line.split(" ");
		
		key = keyValPair[0];
        if(keyValPair.length==1)
        {
            value="";
        }else {
            value = keyValPair[1];
        }
		
		if(keyValPair.length>2)
			for(int i = 2; i < keyValPair.length;i++)
			value+=" "+keyValPair[i];
		
		tempHash.put(key.trim(),value.trim());
	}
	
	
	private static void add(String section)
	{
        Log.d("adding",section);
		content.put(section.replace("[","").replace("]", "").trim(),tempHash);
		tempHash = new LinkedHashMap<String,String>();
	}
}
