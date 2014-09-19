package com.samsung.RDBMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import com.kapil.interface.BPlusTree.BTree;



	@SuppressWarnings("rawtypes")

	public class Table extends BTree<Integer, ArrayList>{
	     
		String name;
		Scanner sc=new Scanner(System.in);
		int no_col,oldno_col,prev;
		int oldrec;
		int oldno_row=0;
		public Map<String,Obj>hm =new HashMap<String,Obj>();
		Map<String,Integer> hm1=new HashMap<String,Integer>();
		String[] sarray;
		ArrayList<String> als=new ArrayList<String>();
		
		public  Table(String name){
			this.name=name;
			oldno_col=0;
			oldrec=0;
		}
		 
		
		public String toString(){
			return  name;
		
			
		}
		public void tabledefination(){ 
		
			hm1.put("int", 0);hm1.put("double",1);hm1.put("string", 2);hm1.put("boolean", 3);hm1.put("char", 4);
			hm1.put("float",5);
			
			System.out.println("no of column");
			prev=no_col=sc.nextInt();
			
			sarray=new String[no_col];
			 
			System.out.println("enter column names and datatypes");
			int i=0;
             while(i<no_col){
            	 String s=sc.next();
            
            	 
            	 String s1=sc.next();
            	 hm.put(s,new Obj(oldno_col+i,s1));
            	 sarray[i]=s1;
            	 als.add(s1);
            	 i++;
             }
            		oldno_col+=no_col;
	    			
	    	System.out.println("scehma of above table is");

	    	Iterator<String> it= hm.keySet().iterator(); 
	    	while (it.hasNext()) {
	           
				String pairs = it.next();
	            System.out.print(pairs + "\t");
	            
	        }	
	    	 System.out.println();
	    	 System.out.println("Datatype of above table is");

	    	 List<Obj> list1 = new ArrayList<Obj>(hm.values());
	    	 for(Obj foo: list1){
	    		
	    		 System.out.print(foo.datatype+" \t");
	    		}
				
	    	 System.out.println();
			}
		
		
		
		
		public ArrayList<Comparable> addcolumn(){
		ArrayList<Comparable> val=new  ArrayList<Comparable>(); 
		           int j=0;
		           Random rand = new Random();
		           
					while(j<oldno_col)
					{  
					
					 //  int x=hm1.get(sarray[j]);
					   int y=hm1.get(als.get(j));
					switch(y){
					   case 0 :val.add(rand.nextInt(1000));
					   break;
					   case 1 :val.add(rand.nextDouble());
						   break;
					   case 2 :val.add(UUID.randomUUID().toString());
						   break;
					   case 3 :val.add(rand.nextBoolean());
						   break;
					   case 4:val.add(UUID.randomUUID().toString().charAt(0));
						   break;
					   default:val.add(rand.nextFloat());
					   break;
					   }j++;
						
					}oldrec++;
					return val;  
		}
		
	    
}
	

