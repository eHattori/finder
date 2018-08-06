
package com.hattori.finder.exceptions;

/**
 * StoreNotFoundException
 */
public class StoreNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MSG = "Store not found with the specified param";

    public StoreNotFoundException() {
        super(DEFAULT_MSG);
    }

}