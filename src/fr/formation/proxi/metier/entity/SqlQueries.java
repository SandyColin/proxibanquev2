package fr.formation.proxi.metier.entity;

public class SqlQueries {
	public static final String READ_ALL_CLIENT = "SELECT * FROM Client;";
	public static final String READ_CLIENT = "SELECT  '%s' from Client;";
	public static final String UPDATE_CLIENT= "UPDATE CLIENT SET fisrtname ='%s',lastname='%s',email='%s',address='%s' where id=%s; ";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM ACCOUNT;";
	public static final String READ_ACCOUNT = "SELECT * from ACCOUNT where id='%s';";
	public static final String UPDATE_ACCOUNT= "UPDATE ACCOUNT SET number ='%s',balance=%s,savings='%s' where id=%s; ";
	
	
}
