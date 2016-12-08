/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.presentation.bean;

import ch.hearc.ig.odi.movies.business.Movie;
import ch.hearc.ig.odi.movies.business.Person;
import ch.hearc.ig.odi.movies.exception.InvalidParameterException;
import ch.hearc.ig.odi.movies.exception.NullParameterException;
import ch.hearc.ig.odi.movies.exception.UniqueException;
import ch.hearc.ig.odi.movies.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author silvio.gutierre
 */
@Named(value = "personBean")
@ViewScoped
public class PersonBean implements Serializable {

    @Inject
    Services services;

    private Person currentPerson;
    private Long id;

    private Movie addMovie;

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }

    public void initEntity() {
        if (id == null) {
            currentPerson = new Person();
        } else {
            currentPerson = services.getPersonWithId(id);
        }
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getAddMovie() {
        return addMovie;
    }

    public void setAddMovie(Movie addMovie) {
        this.addMovie = addMovie;
    }

    public String save(){
        try {
            services.savePerson(currentPerson);
        } catch (NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailsPerson.xhtml?id=" + currentPerson.getId() + "&faces-redirect=true";
    }

    /**
     * Ajoute le champ "addMovie" à la liste de films de la personne
     * @return Retourne la page de détails de la personne
     */
    public String addMovieToPerson() {
        try {
            services.addMovieToPerson(currentPerson, addMovie);
        } catch (UniqueException | NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "done";
    }
    
    /**
     * Retourne la liste que la personne n'a pas vu.
     * @return La liste que la personne n'a pas vu.
     */
    public List<Movie> getMoviesNotAdded() {
        List<Movie> moviesNotAdded = services.getMoviesList();
        moviesNotAdded.removeAll(currentPerson.getMovies());
        return moviesNotAdded;
    }
    
    /**
     * Supprime le film passé en paramètre de la liste des films de la personne.
     * @param movie Le film à supprimer
     * @return Retourne la page de détails de la personne
     */
    public String removeMovie(Movie movie){
        try{
            services.removeMovieFromPerson(this.currentPerson, movie);
        }catch(InvalidParameterException | NullParameterException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }        
        return "done";
    }
}
