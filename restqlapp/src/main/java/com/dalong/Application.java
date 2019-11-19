package com.dalong;

import restql.core.RestQL;
import restql.core.config.ClassConfigRepository;
import restql.core.response.QueryResponse;

public class Application {
    public static void main(String[] args) {
        ClassConfigRepository config = new ClassConfigRepository();
        config.put("planets", "https://swapi.co/api/planets/:id");

        RestQL restQL = new RestQL(config);
        QueryResponse response = restQL.executeQuery("from planets timeout 3000 with id = ?", 1);

        System.out.println("The response JSON is: " + response.toString());
    }
}
