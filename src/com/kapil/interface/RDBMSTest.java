package com.samsung.RDBMS;

import java.util.Scanner;

public class RDBMSTest {
	public static void main(String args[]){
		
		long startTime = System.nanoTime();
		
		RDBMS btf=new RDBMS();
		
		Scanner sc=new Scanner(System.in);
		//creating database
		Database db1=btf.createdb("abc");
		
		//creating table and associated with particular database
		Table tb=btf.createtable("table1", db1);
		
		//defining table defination of above created table
		btf.addschemaa(tb);
		btf.enterrows(tb);
		btf.addschemaa(tb);{btf.enterrowscol(tb, 2);}
		//btf.addschemaa(tb);
		//adding row in table
		btf.enterrows(tb);
		btf.enterrows(tb);
		//filtering table on particular column 
		System.out.println("input name of column u want to filter and value");
		String s=sc.next();
		int x=sc.nextInt();
		btf.filtering(tb,s,x);
		
		System.out.println("show list of table currently present in particular database ");
		//show list of table currently present in particular database 
		btf.list_table(db1);
		
		System.out.println("Creating new table ");
	    Table tb2=btf.createtable("table2", db1);
		btf.addschemaa(tb2);
		
		System.out.println("enter tablename with which u want foriegn key relation of above table");
		String tbnm=sc.next();
		// Creating table with foreign key
		btf.foriegn_addrows(tb2,tb);
		
		System.out.println("list of table");
		btf.list_table(db1);
		
		System.out.println("enter the id u want to search in table1");
		int idnm=sc.nextInt();
		//searching on the table without foreign key
		btf.search(tb, idnm);
		
		System.out.println("enter the id u want to search in table2 and if any record associate with its id as foriegn key");
		int idmn1=sc.nextInt();
		//searching on the table having foreign key reference
		btf.searchforiegn(tb2, idmn1);
		
		System.out.println("enter the id u want to delete in table2 and if any record associate with its id as foriegn key");
		idmn1=sc.nextInt();
		//delete the table record and if foreign key associate record
		btf.deleteforiegn(tb2, tb, idmn1);
		
		System.out.println("enter id for record u want to delete speified to table1");
		 idmn1=sc.nextInt();
		//DELETE Only specified table record
		btf.remover(tb, idmn1); 
		
		System.out.println();
		long endTime = System.nanoTime();

		long duration = endTime - startTime;
		System.out.println("time taken is : " +duration); 

		
	//	long startTime = System.nanoTime();
		 
		/*dbms dbms1=new dbms();
		
		System.out.println("create database");
		database d=new database("abc");
		dbms1.listdb.add(d);
		
		System.out.println("database in our dbms "+dbms1.listdb );
		
		System.out.println("create table in database");
		table t=new table("first table");
		table t1=new table("second table");
		d.hsm.put("firsttable", t);
		d.hsm.put("secondtable", t1);
		
		System.out.println("adding above create table in database");
		d.tb.add(t);
		d.tb.add(t1);
		
		
		
		System.out.println("input the schema of a table");
		t.addsechma();
		t1.addsechma();
		
		System.out.println("name of the db  "+d.name);
		System.out.println("name of table present in "+d.name +" db is "+d.tb);
		
		System.out.println("add row in firsttable");
		final int INSERTS = 50;
		for (int i=0;i<INSERTS;i++){
			 
			  d.hsm.get("firsttable").insert(i,t.addcolumn()); 
		}  
		System.out.println();
		System.out.println("add row in secondtable ");
		for (int i=0;i<INSERTS;i++){
			 
			d.hsm.get("secondtable").insert(i,t1.addcolumn()); 
		} 
		
	System.out.println(" filtering ");
		System.out.println("print only key which having value greater than 500 in column val2 ");
		for(int i=0;i<INSERTS;i++){
			int x=(Integer) d.hsm.get("secondtable").search(i).get((Integer)d.hsm.get("secondtable").hm.get("val2").code);
			if(x>500)
			System.out.print(i+" ");
		}  
		
		System.out.println("remove for id 2");
		d.hsm.get("firsttable").delete(2);{d.hsm.get("secondtable").delete(2);}
		System.out.println();
		long endTime = System.nanoTime();

		long duration = endTime - startTime;
		System.out.println("time taken is : " +duration);  */
		
		
		
		
		
		
		
		
		
		
		
	/*	System.out.println("tree1");
		//IntegerBTree tree = new IntegerBTree();
		
		
		//BTreeTest tr=new BTreeTest();
		
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("name of id 2 :"+tr.search(2).get((Integer) schema.get("name")));
		System.out.println(" ");
		System.out.println(" filtering ");
		System.out.println("print only key which having vlaue greater than 500 in column val1 ");
		for(int i=0;i<INSERTS;i++){
			int x=(Integer) tr.search(i).get((Integer)schema.get("val1"));
			if(x>500)
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("tree 2");
	//	IntegerBTree tree1 = new IntegerBTree();
		BTreeTest tr1=new BTreeTest();
		
		//tree1.insert1(tree.search(2),199);{System.out.println("search value is" +tree.search(2));}
		tr1.insert(2,199);
		// search in all collection for particular id
		
		for (int i=0;i<INSERTS;i++){
			 // int key = generator.nextInt(VALUE_LIMIT);
			 ArrayList val=new  ArrayList();
			   val.add( generator.nextInt(VALUE_LIMIT));
			  
			   val.add( UUID.randomUUID().toString());
		//	  values[i] = val;
			//  tree.insert(i,val); 
			  tr1.insert(i,val); 
			}  
		System.out.println();
		System.out.println("search for id 2");
		System.out.println("search value are" +tr.search(2)+" "+tr1.search(2));
		
	   
			
		//remove all collection for particular id
		
		System.out.println("remove for id 2");
		tr.delete(2);{tr1.delete(2);}
		System.out.println();
		long endTime = System.nanoTime();

		long duration = endTime - startTime;
		System.out.println("time taken is : " +duration); */
	
		
		
	}
}




	




