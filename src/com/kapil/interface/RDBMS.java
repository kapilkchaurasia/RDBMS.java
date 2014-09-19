package com.kapil.interface.RDBMS;


import java.util.ArrayList;
import java.util.Scanner;

import com.samsung.BPlusTree.BTreeLeafNode;



public class RDBMS {

	
   Dbms dbmsf;
   Database dbf;
   Table tablef;
    int no_row;
    ArrayList<Comparable> val=new  ArrayList<Comparable>(); 
   Scanner sc=new Scanner(System.in);
   public  RDBMS(){
	   dbmsf=new Dbms();
	
	   
   }
   public Database createdb(String dbname){
	  dbf=new Database(dbname);
	  return dbf;
	 
	  
   }
   public void list_db(Dbms dbmsname ){
	   System.out.println("database in our dbms "+dbmsname.listdb );
	   
   }
   
   public void list_table(Database dbname ){
	   System.out.println("table in our dbms "+dbname.tb );
	   
   }
   public Table createtable(String tablename,Database dbname){
	   tablef=new Table(tablename);
	   dbname.tb.add(tablef);
	   return tablef;
   }
   
   public void addschemaa(Table tablename){
	   tablename.tabledefination();
   }
   public void enterrows(Table tablename){
	   int i;
	    System.out.println("how many row");
	     no_row=sc.nextInt();
		for (i=tablename.oldno_row;i<tablename.oldno_row+no_row;i++){
			
			  tablename.insert(i,tablename.addcolumn()); 
		} 
		tablename.oldno_row=i;
		System.out.println();
   }
   
   public void enterrowscol(Table tablename,int addicol){
	   
		for (int i=0;i<tablename.oldno_row;i++){
			val= tablename.search(i); 
			for(int g=0;g<addicol;g++){val.add(null);}
			tablename.insert(i,val); 
		} 
		
		System.out.println();
   }
   
   public void filtering(Table tablename,String colunm_nm,int value){
	   System.out.println("filtering  ");
	  
	   for(int i=0;i<tablename.oldno_row;i++){
			int x=(Integer) tablename.search(i).get((Integer)tablename.hm.get(colunm_nm).code);
			if(x>value)
			System.out.print(i+" ");
		} 
	   System.out.println();
   }
   
   
   public void search(Table tablename,int id){
	   System.out.println();
	    System.out.println("search for id "+id);
		System.out.println(tablename.search(id));
     
   }

   public void remover(Table tablename,int id){
	   System.out.println();
	   System.out.println("remove for id "+id);
		tablename.delete(id);
   }
   
   public void foriegn_addrows(Table original, Table foriengnt){
	   System.out.println("how many row");
	   int no=sc.nextInt();
	   for (int i=0;i<no;i++){
		   
		   original.insert(i,original.addcolumn());
		   
		}
	   System.out.println();
	   for (int i=0;i<no;i++){
		  
		   BTreeLeafNode<?, ?> x= foriengnt.foriegn(i); 
		   //original.insert(i,original.addcolumn());
		   original.foriegnkeyadd(x,i);
		  original.searchforiegn(i);
		   
		}
   }
	   public void searchforiegn(Table original, int i){
		      original.searchforiegn(i);
			    
	   
	   
   }
	   public void deleteforiegn(Table original,Table foriengn, int i){
		      original.delete(i);
		      foriengn.delete(i);
			    }
}
