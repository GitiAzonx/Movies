/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.presentation.bean;

import ch.hearc.ig.odi.movies.business.Movie;
import ch.hearc.ig.odi.movies.business.Person;
import ch.hearc.ig.odi.movies.exception.NullParameterException;
import ch.hearc.ig.odi.movies.service.Services;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author silvio.gutierre
 */
@Named(value = "movieBean")
@ViewScoped
public class MovieBean implements Serializable{

    @Inject
    Services services;

    private Movie currentMovie;
    private Long id;

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
    
    public void initEntity() {
        if (id == null) {
            currentMovie = new Movie();
        } else {
            currentMovie = services.getMovieWithId(id);
        }
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   
    
    public String save(){
        try {
            services.saveMovie(currentMovie);
        } catch (NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailsMovie.xhtml?id=" + currentMovie.getId() + "&faces-redirect=true";
    }
}
