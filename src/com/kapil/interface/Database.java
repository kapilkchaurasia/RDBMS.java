package com.samsung.RDBMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.samsung.RDBMS.Table;

public class Database{
	
	String name;
	public List<Table> tb=new ArrayList<Table>();
	HashMap<String,Table> hsm=new HashMap<String,Table>();
	
	
	public Database(String name) {
		this.name=name;
	}
    
	
	     
	public String toString(){
		return name;
		
	}
	
	}
