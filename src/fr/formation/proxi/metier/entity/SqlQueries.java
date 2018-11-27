package fr.formation.proxi.metier.entity;

/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 *La classe SqlQueries contient toutes les requetes SQL nécessaires au projet
 */
public class SqlQueries {
	public static final String READ_ALL_CLIENT = "SELECT * FROM Client;";
    public static final String READ_CLIENT = "SELECT * from Client where id='%s';";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM ACCOUNT;";
	public static final String READ_ACCOUNT = "SELECT * from ACCOUNT where id_client='%s';";
	public static final String UPDATE_ACCOUNT= "UPDATE ACCOUNT SET number ='%s',balance=%s,savings='%s' where id=%s; ";
    public static final String UPDATE_CLIENT= "UPDATE CLIENT SET %s='%s' where id=%s; ";
    public static final String READ = "SELECT * from  Account where id='%s';";
	
	
	
}
