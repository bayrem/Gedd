package com;

import java.sql.*;

import core.Ged;
 
/**
 * This class demonstrates how to create a connection
 * to a SQLite database using JDBC with the DriverManager.
 */
public class SQLiteDemo
{
	public Ged gedd;
	Connection c = null;
    Statement stmt = null;
    
	public void connecter()
	{
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:DB55.db");
	      c.setAutoCommit(false);
	      System.out.println("connecter : Opened database successfully");
	      stmt = c.createStatement();
	    }
	    catch(Exception e)
	    {System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("conncter : Operation done successfully");
	}
	
	public SQLiteDemo(Ged g){
		this.gedd = g;
	}
	
	public void supprimer(String titre)
	{
		connecter();
	      
	      try{
	      String sql = "DELETE from document Where Titre='"+titre+"';";
	      stmt.executeUpdate(sql);
	      c.commit();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("supprimer : Operation done successfully");
	  }

	
	public Ged getElements()
	{

		connecter();
		try{
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM Document" );
	    
	      while ( rs.next() ) {
	    	 Element elem;
	         String titre = rs.getString("Titre");
	         String  auteur = rs.getString("Auteur");
	         String datecreation = rs.getString("DateCreation");
	         String type=rs.getString("Type");
	      switch (type) {
	 		case "photo": elem = new Photo(titre,auteur,datecreation,type);
	 			break;
	 			
	 		case "video": elem = new Video(titre,auteur,datecreation,type);
	 			break;

	 		default: elem = new Doc(titre,auteur,datecreation,type);
	 			break;
	 		}
	      
	    //ImporterSerie(elem);
	    //ImporterTag(elem);
		gedd.remplirList(elem);	      
	          }
	      
	      c.commit();
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		System.out.println("getelement : Operation done successfully");
		return gedd;
	    
	}
	
	
	public void DropAllTable()
	{
		connecter();
		try{
			String sql="DROP TABLE docuemnt";
			stmt.executeUpdate(sql);
		    c.commit();
			
		}
		 catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("droptable : Operation done successfully");
		}	
	
	public void InsertTag(Element elem,String tag)
	{connecter();
	try{
	      String sql = "INSERT INTO Organisation " +
	                   "VALUES ('"+tag+"','"+elem.getTitre()+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("inserttag : Records created successfully");
	  }
	
	public void InsertSerie(Element elem,String Serie)
	{connecter();
	try{
	      String sql = "INSERT INTO Collection " +
	                   "VALUES ('"+Serie+"','"+elem.getTitre()+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("insertserie : Records created successfully");
	  }
	
	public void InsertDocument(Element elem)
	{
		connecter();
		try{
	      String sql = "INSERT INTO Document " +
	                   "VALUES ('"+elem.getTitre()+"','"+elem.getAuteur()+"','"+elem.getDate()+"','"+elem.getType()+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("insertdocument : Records created successfully");
	  }
	

	
	public void setElement(Element elem,String Titre)
	{
		connecter();
		try{
	      String sql = "UPDATE Document set Titre ='"+elem.getTitre()+"',Auteur ='"+elem.getAuteur()+"',DateCreation='"+elem.getDate()+"' Where Titre='"+Titre+"'";
	      stmt.executeUpdate(sql);
	      c.commit();
	     
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("updateelement : Operation done successfully");
	  }
	
public void ImporterTag(Element elem)
{
	connecter();
	try{
      ResultSet rs = stmt.executeQuery( "SELECT description FROM organisation Where Titre='"+elem.getTitre()+"'");
    
      while ( rs.next() ) {
         String description = rs.getString("Titre");
		 elem.getTags().add(description);
			      
          }
      
      c.commit();
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
	System.out.println("importertag : Operation done successfully");
	


}
public void ImporterSerie(Element elem)
{
	connecter();
	try{
      ResultSet rs = stmt.executeQuery( "SELECT description FROM Collection Where Titre='"+elem.getTitre()+"'");
    
      while ( rs.next() ) {
         String description = rs.getString("Titre");
		 elem.getTags().add(description);
			      
          }
      
      c.commit();
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
	System.out.println("importerserie : Operation done successfully");
	
}
	

public void CreateTables() throws SQLException
{
	connecter();
			try{		 	
            String sql = "CREATE TABLE Document(Titre char(30)Primary key,Auteur char(30), DateCreation char(20),Type char(20))";
            stmt.executeUpdate(sql);
			} catch ( Exception e ) {
				System.err.println("Erreur creation table Document "+ e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
			}
			try{
            String sql="CREATE TABLE Tags(description char(20) Primary key)";
            stmt.executeUpdate(sql);
            stmt.close();
           
			} catch ( Exception e ) {
		  	      System.err.println("Erreur creation table Tags"+ e.getClass().getName() + ": " + e.getMessage() );
		  	      System.exit(0);
		  	    }
			try {
            String sql="CREATE TABLE Serie(description char(20) PRIMARY KEY)";
            stmt.executeUpdate(sql);
            
			} catch ( Exception e ) {
		  	      System.err.println("Erreur creation table Serie"+ e.getClass().getName() + ": " + e.getMessage() );
		  	      System.exit(0);
		  	    }
           try{
        	   String sql="CREATE TABLE Collection(serie char(20) References Serie(Description) ,Titre char(30) References Document(Titre), PRIMARY KEY (Serie,Titre))";
            stmt.executeUpdate(sql);
           } catch ( Exception e ) {
       	      System.err.println("Erreur creation table Collection"+ e.getClass().getName() + ": " + e.getMessage() );
       	      System.exit(0);
       	    }
         
           try{
        	String sql="CREATE TABLE Organisation(tag char(20) References Tags(description),Titre var(30) References Document(Titre),PRIMARY KEY(tag,Titre))";
            stmt.executeUpdate(sql);
           } catch ( Exception e ) {
       	      System.err.println("Erreur Update table Organisation"+ e.getClass().getName() + ": " + e.getMessage() );
       	      System.exit(0);
       	    }
          
            c.commit();
            stmt.close();
  	      	c.close();
  	    
  	    System.out.println("createtables : Operation done successfully");
  	  }
  	
        
}