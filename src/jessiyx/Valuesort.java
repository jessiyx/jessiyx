package jessiyx;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Valuesort {
	static Scanner in = new Scanner(System.in);
	  void valuesort(Map<String, Integer> Map) {  
	        Set<Entry<String,Integer>> mapEntries = Map.entrySet();   
	        LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(mapEntries);  
	        //����ӳ���ֵ���б�����
	        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
	            @Override  
	            public int compare(Entry<String, Integer> ele1,  Entry<String, Integer> ele2) {  	  
	                return ele2.getValue().compareTo(ele1.getValue());  
	            }  
	        });  
	  
	        Map<String,Integer> Map2 = new LinkedHashMap<String, Integer>();  
	        for(Entry<String,Integer> entry: List) {  
	            Map2.put(entry.getKey(), entry.getValue());  
	        }  
	  
	        // ������Ҫ�鿴�Ĵ�Ƶ��ߵ�ǰK������
	        System.out.println("��������Ҫ�鿴�Ĵ�Ƶ��ߵĵ��ʸ�����");
	        int n = in.nextInt();
	        for(Entry<String,Integer> entry : Map2.entrySet()) {  
	            System.out.println(entry.getKey() + " - " + entry.getValue());  
	            n--;
	            if(n<=0)	
	            break;
	        } 
	       
	    } 
}
