package fr.formation.proxi.persistance;

import java.util.List;

public interface Dao<T> {


/**
* 
* La méthode read() lit les informations d'une entité en BDD.
* 
* @param id identifiant unique de l'entité.
* @return T l'entité construite à partir des informations récupérées.
*/
public T read(Integer id);  


/**
* La méthode readAll() récupère toutes les entités d'une table (àl'aide d'une requête SQL). 
* 
* @return List<T>Une liste des entités récupérées. 
*/
public List<T> readAll();


/**
* La méthode update() met à jour une entité d'une BDD.
* @param entity L'entité à mettre à jour avec de nouvelles informations.
* @return T L'entité nouvellement mise à jour. 
*/
public T update(T entity); 



}
