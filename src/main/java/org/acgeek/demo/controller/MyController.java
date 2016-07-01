package org.acgeek.demo.controller;

import org.rapidoid.annotation.Controller;
import org.rapidoid.annotation.GET;
import org.rapidoid.security.annotation.Roles;

/**
 * Created by Siglud on 2016/7/2.
 */
@Controller
public class MyController {
    @GET("/")
    public Object home(){
        return "This is public!";
    }

    @GET
    @Roles("administrator")
    public Object manage() {
        return "Welcome, Mr. Manager!";
    }
}
