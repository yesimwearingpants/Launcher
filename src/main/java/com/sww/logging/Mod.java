/**
 * Copyright (c) 2015 Greg Wright
 *	
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sub-license, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the terms of the MIT License
 * 
 * @author yesimwearingpants
 * Created June 17, 2015
 */
package com.sww.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Mod {

    String modid();

    String name() default "";

    String version() default "";

    String dependencies() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface EventHandler{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Instance {
        /**
         * The mod object to inject into this field
         */
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Metadata {
        /**
         * The mod id specifying the metadata to load here
         */
        String value() default "";
    }

}
