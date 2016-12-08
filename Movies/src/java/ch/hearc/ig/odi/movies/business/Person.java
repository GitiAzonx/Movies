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
public class Person {
    
    private Long id;
    private String firstName;
    private String lastName;
    private List<Movie> movies;

    public Person() {
        this.movies = new ArrayList<>();
    }

    public Person(Long id, String firstName, String lastName) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    /**
     * Ajoute un film à la liste de la personne, et ajoute cette personne à la liste des personnes du film.
     * @param movie Le film à ajouter à la liste
     * @throws UniqueException Levée si la liste contient déjà ce film
     * @throws NullParameterException Levée si le paramètre est null
     */
    public void addMovie(Movie movie)throws UniqueException, NullParameterException{
        if(movie == null){
            throw new NullParameterException("Movie is null");
        }        
        if(movies.contains(movie)){
            throw new UniqueException("Error, the movie is already in the list");
        }        
        movie.addPerson(this);
        movies.add(movie);            
    }
    
    /**
     * Supprime le film passé en paramètre de la liste de la personne et supprime cette personne de la liste de personne de ce film
     * @param movie Le film à supprimer de la liste
     * @throws NullParameterException Dans le cas où le paramètre est null
     * @throws InvalidParameterException Dans le cas où le film à supprimer n'est déjà pas dans la liste
     */
    public void removeMovie(Movie movie) throws NullParameterException, InvalidParameterException{
        if(movie == null){
            throw new NullParameterException("Movie is null");
        }        
        if(movies.remove(movie)){
            throw new InvalidParameterException("That movie doesn't appear in the list");
        }
        movie.removePerson(this);                     
    }
}
