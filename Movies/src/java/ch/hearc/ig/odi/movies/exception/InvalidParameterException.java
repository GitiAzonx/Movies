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
public class InvalidParameterException extends Exception{
    
    public InvalidParameterException(){
        super();
    }
    
    public InvalidParameterException(String message){
        super(message);
    }
    
    public InvalidParameterException(String message, Throwable cause){
        super(message, cause);
    }
    
}
