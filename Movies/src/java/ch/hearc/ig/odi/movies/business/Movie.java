/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.business;

import ch.hearc.ig.odi.movies.exception.InvalidParameterException;
import ch.hearc.ig.odi.movies.exception.NullParameterException;
import ch.hearc.ig.odi.movies.exception.UniqueException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author silvio.gutierre
 */
public class Movie {
    
    private Long id;
    private String name;
    private String producer;
    private List<Person> people;

    public Movie() {
        this.people = new ArrayList<>();
    }

    public Movie(Long id, String name, String producer) {
        this();
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }   
       
    /**
     * Ajoute une personnes à la liste de personnes qui ont vu le film.
     * @param person La personne à ajouter
     * @throws UniqueException Dans le cas où la personne est déjà dans la liste
     * @throws NullParameterException Dans le cas où le paramètre person est null
     */
    public void addPerson(Person person) throws UniqueException, NullParameterException{
        if(person == null){
            throw new NullParameterException("Person is null");
        }        
        if(people.contains(person)){
            throw new UniqueException("That person has already seen that movie");
        }        
        people.add(person);
    }
    
    /**
     * Supprime la personne passée en paramètre de la liste des personnes qui ont vu le film.
     * @param person La personne à supprimer de la liste
     * @throws NullParameterException Dans le cas où le paramètre person est null
     * @throws InvalidParameterException Dans le cas où as la personne passée en paramètre.
     */
    public void removePerson(Person person) throws NullParameterException, InvalidParameterException{
        if(person == null){
            throw new NullParameterException("Person is null");
        }                
        if(!people.remove(person)){
            throw new InvalidParameterException("That person already is not in the list");
        }        
    }
    
}
