/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movies.exception;

/**
 *
 * @author silvio.gutierre
 */
public class UniqueException extends Exception{
    
    public UniqueException(){
        super();
    }
    
    public UniqueException(String message){
        super(message);
    }
    
    public UniqueException(String message, Throwable cause){
        super(message, cause);
    }
    
}
