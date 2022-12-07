package com.example.resttemplate.domain.entity;

import java.util.List;

@lombok.Data
public class Page {

    private   String status;
    private List<Data> data ;
    private String message;

}
