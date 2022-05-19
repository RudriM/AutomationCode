package com.wac.cwp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.wac.cwp.base.TestBase;

public class DataBaseActions extends TestBase {
	
	 public static int DataBaseConnectAndPerform(HashMap<String, String> map, String Action ) throws Exception {
		 
		    // Connect to database
			String selectSql = null;
		    String dbuser = prop.getProperty("dbUserName");
		    String dbpassword = prop.getProperty("dbPassword"); 
		    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
		        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", map.get("HostName"), map.get("DBName"), dbuser, dbpassword);
		    
		    ResultSet resultSet = null;
		    Connection connection = null;
		    Statement statement = null;
		    int result;
			
		    connection = DriverManager.getConnection(url);
		    String schema = connection.getSchema();
		    log.info("Successful connection - Schema: " + schema);
		   
		    
		    if (Action.equalsIgnoreCase("Search"))
		    {
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("One"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1")+"'";
			    }
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("Two"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1") +"' And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"'" ;
			    }
			    
			    log.info("The SQL query ran against db is: " + selectSql);
			    statement = connection.createStatement();
			    resultSet = statement.executeQuery(selectSql);
			 }
		    
		    if (Action.equalsIgnoreCase("Delete"))
		    {
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("One"))
			    {
			    	selectSql = "DELETE FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1")+"'";
			    }
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("Two"))
			    {
			    	selectSql = "DELETE FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1") +"' And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"'" ;
			    }
			    
			    log.info("The SQL query ran against db is: " + selectSql);
			    statement = connection.createStatement();
			    statement.executeUpdate(selectSql);
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("One"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1")+"'";
			    }
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("Two"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1") +"' And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"'" ;
			    }
			    
			    log.info("The SQL query ran against db is: " + selectSql);
			    statement = connection.createStatement();
			    resultSet = statement.executeQuery(selectSql);
			 }
		    
		    
		    if (Action.equalsIgnoreCase("Update"))
		    {
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("One"))
			    {
			    	selectSql = "Update "+map.get("TableName")+" Set "+map.get("UpdateColumnName")+" = "+map.get("UpdateColumnValue")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1")+"'";
			    }
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("Two"))
			    {
			    	selectSql = "Update "+map.get("TableName")+"Set "+map.get("UpdateColumnName")+" = "+map.get("UpdateColumnValue")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1") +"' And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"'" ;
			    }
			    
			    log.info("The SQL query ran against db is: " + selectSql);
			    statement = connection.createStatement();
			    statement.executeUpdate(selectSql);
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("One"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1")+"'";
			    }
			    
			    if (map.get("NoOfColumnsToLook").equalsIgnoreCase("Two"))
			    {
			    	selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where "+map.get("ColumnName1")+" = '"+ map.get("ColumnValue1") +"' And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"'" ;
			    }
			    
			    log.info("The SQL query ran against db is: " + selectSql);
			    statement = connection.createStatement();
			    resultSet = statement.executeQuery(selectSql);
			 }
		    
		     resultSet.next();
		     log.info("The Count of the required data in database: " +resultSet.getInt(1));
		     result = resultSet.getInt(1);
		     
			            
		       	 if(resultSet != null) {
		       		 try {
		       			 resultSet.close();
		       		 } catch (Exception e) {
		       			 
		       		 }
		       	 }
		       	 if (statement != null) {
		       	 	 try {
		       		 statement.close();
		       	 	 } catch (Exception e) {
		       	 	 }
		       	 }
		       	 
		       	 if (connection != null) {
		       		 try {
		       		 connection.close();
		       		 } catch (Exception e) {
		       		 }
		       	 }           
			   
			    return result;
			}
			 
			 
			 public static int DataBaseGetNullDomainLoginCountForRequrdBranch(HashMap<String, String> map) throws Exception {
				 
				    // Connect to database
					String selectSql = null;
				    String dbuser = prop.getProperty("dbUserName");
				    String dbpassword = prop.getProperty("dbPassword"); 
				    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
				        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", map.get("HostName"), map.get("DBName"), dbuser, dbpassword);
				    
				    ResultSet resultSet = null;
				    Connection connection = null;
				    Statement statement = null;
				    int result;
					
				    connection = DriverManager.getConnection(url);
				    String schema = connection.getSchema();
				    log.info("Successful connection - Schema: " + schema);
				   
					    
		    		selectSql = "SELECT COUNT (*) FROM "+map.get("TableName")+" where DomainLogin is null And "+ map.get("ColumnName2")+" = '"+ map.get("ColumnValue2")+"' And UserName Like '"+map.get("OTISCode")+"%'";
				    log.info("The SQL query ran against db is: " + selectSql);
				    statement = connection.createStatement();
				    resultSet = statement.executeQuery(selectSql);		    
				    resultSet.next();
				    log.info("The Count of the required data in database: " +resultSet.getInt(1));
				    result = resultSet.getInt(1);
				     
					            
			       	 if(resultSet != null) {
			       		 try {
			       			 resultSet.close();
			       		 } catch (Exception e) {
			       			 
			       		 }
			       	 }
			       	 if (statement != null) {
			       	 	 try {
			       		 statement.close();
			       	 	 } catch (Exception e) {
			       	 	 }
			       	 }
			       	 
			       	 if (connection != null) {
			       		 try {
			       		 connection.close();
			       		 } catch (Exception e) {
			       		 }
			       	 }           
				   
				    return result;
				}

}
