/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.accenture.exon.searchservice.exception;

public class SearchException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 3451393557413794472L;
    private String code;
    private String reason;
    private String message;
    private String source;

    public SearchException(){
        super();
    }

    public SearchException(String message){
        super(message);
        this.message = message;
    }

    public SearchException(Throwable cause) {
        super(cause);
    }

    public SearchException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public SearchException(String code, String reason,
                               String message, String source){
        super(message);
        this.code= code;
        this.reason = reason;
        this.message = message;
        this.source = source;
    }
}
