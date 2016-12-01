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
public class NullParameterException extends Exception{
    
    public NullParameterException(){
        super();
    }
    
    public NullParameterException(String message){
        super(message);
    }
    
    public NullParameterException(String message, Throwable cause){
        super(message, cause);
    }
    
}
