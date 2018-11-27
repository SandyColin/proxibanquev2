package fr.formation.proxi.persistance;

import java.util.List;

public interface Dao<T> {


/**
* 
* Lit les informations d'une entité en BDD.
* 
* @param id identifiant unique de l'entité.
* @return l'entité construite à partir des informations récupérées.
*/
public List<T> read(Integer id);  //dans Hibernate, on utilise que des objets, aucun primitif.


/**
* Récupère toutes les entités d'une table (requête de type SELECT * FROM table). 
* 
* @return Une liste des entités récupérées. 
*/
public List<T> readAll();


/**
* Met à jour une entité d'une BDD.
* @param entity L'entité à mettreà jour avec de nouvelles informations.
* @return L'entité nouvellement mise à jour. 
*/
public T update(T entity); 



}
