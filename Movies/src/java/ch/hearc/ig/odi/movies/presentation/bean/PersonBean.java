/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.presentation.bean;

import ch.hearc.ig.odi.movies.business.Person;
import ch.hearc.ig.odi.movies.service.Services;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author silvio.gutierre
 */
@Named(value = "personBean")
@ViewScoped
public class PersonBean {

    @Inject
    Services services;

    private Person currentPerson;
    private Long id;

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
    
}
