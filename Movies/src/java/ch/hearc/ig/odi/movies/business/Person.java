/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.business;

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
    
    public void addMovie(Movie movie)throws UniqueException, NullParameterException{
        if(movie == null){
            throw new NullParameterException("Movie is null");
        }           
        
        if(movies.contains(movie)){       
            throw new UniqueException("Error, the person has already seen this movie");            
        }
        
        movie.addPerson(this);
        movies.add(movie);
    }
    
    public void removeMovie(Movie movie) throws NullParameterException, UniqueException{
        if(movie == null){
            throw new NullParameterException("Movie is null");
        }           
        
        boolean success = movies.remove(movie); 
        
        if(!success){
            throw new UniqueException("The movie doestn't exist in this list");
        }
                
        movie.removePerson(this);
    }
}
