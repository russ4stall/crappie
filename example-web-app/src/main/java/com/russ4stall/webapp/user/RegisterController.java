package com.russ4stall.webapp.user;

import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Raw;

/**
 * @author Russ Forstall
 */
public class RegisterController {

    public CrappieResult index() {

        System.out.println("index ran!!!");

        return new Raw("test");
    }
}
