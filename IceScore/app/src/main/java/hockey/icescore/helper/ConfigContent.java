package hockey.icescore.helper;

import android.util.Log;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ConfigContent {
	
	private LinkedHashMap<String,LinkedHashMap<String,String>> contentGlobal;
	private String sectionView = "";
	
	public ConfigContent(LinkedHashMap<String,LinkedHashMap<String,String>> content)
	{
		contentGlobal = content;
	}
	
	public ConfigContent()
	{				
		
	}
	
	public void setContent(LinkedHashMap<String,LinkedHashMap<String,String>> content)
	{
		contentGlobal = content;
	}
	
	public String[] getKeys(String section){
	
		Object[] contentArray = contentGlobal.get(section).keySet().toArray();
		String[] keys = new String[contentArray.length];
		int count = 0;
		for(Object str : contentArray)
		{
			keys[count] = str.toString();
			count++;
		}
		return keys ;
		
	}
	
	public String[] getKeysFromSectionView(){
		
		Object[] contentArray = contentGlobal.get(sectionView).keySet().toArray();

		String[] keys = new String[contentArray.length];
		int count = 0;
		for(Object str : contentArray)
		{
			keys[count] = str.toString();
			count++;
		}
		return keys ;
	}
	
	public String getValue(String section,String key){
		return contentGlobal.get(section).get(key);
	}
	
	public void setSectionView(String section)
	{
		sectionView = section;
	}
	
	public String getValueFromSectionView(String key)
	{
        if (!contentGlobal.get(sectionView).containsKey(key)) {
            return "";
        }else
        return contentGlobal.get(sectionView).get(key);
	}

    public String[] getSections()
    {
        Set<String> contentArray = contentGlobal.keySet();
        Log.d("numsec", contentArray.size()+"");
        String[] keys = new String[contentArray.size()];
        int count = 0;
        for(Object str : contentArray)
        {
            keys[count] = str.toString();
            count++;
        }
        return keys ;
    }
	
	public boolean hasKeyInSection(String section,String key)
	{
		return contentGlobal.get(section).containsKey(key);
	}
	
	public boolean hasSection(String section)
	{
		return contentGlobal.containsKey(section);
	}

}
