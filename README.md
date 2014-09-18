RDBMS.java
==========

In this I try to code RELATIONAL DATABASE MGMT. SYSTEM from ground zero in java. In this I use B+TREE as my underlined data structure and use Facade design pattern. 
It has following feature's:-



1.CRUD opeartion.
 2.indexing on primay key given by user.
 3.foriegn table suppport.
 4.RDBMS can have many database.Each DB can have many tables associated with it.
 5.on changing foriegn key record trigger appropriate effect in child table(ex. on deletion).
 6.Can add column inbetween,without worrying of already insert records
 
 
 
 SRC code repo contain RDBMS.java file which is interface of the project and also include test file as "RDBMSTest" which extend interface file i.e.,RDBMS.java .
