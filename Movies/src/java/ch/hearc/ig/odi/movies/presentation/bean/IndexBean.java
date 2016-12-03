/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.presentation.bean;

import ch.hearc.ig.odi.movies.business.Movie;
import ch.hearc.ig.odi.movies.business.Person;
import ch.hearc.ig.odi.movies.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author silvio.gutierre
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean implements Serializable{
    
    @Inject Services services;
    private List<Movie> movies;
    private List<Person> people;
    
    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }

    public String initLists(){
        this.movies = services.getMoviesList();
        this.people = services.getPeopleList();
        return "/index.xhtml";
    }
    
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
}
