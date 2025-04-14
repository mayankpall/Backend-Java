package com.bridgelabz.restapi_demo.controller;

import com.bridgelabz.restapi_demo.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello From BridgeLabz";
    }

    @GetMapping("/hello/query")
    public String sayHelloQuery(@RequestParam(value = "name")String name){
        return "Hello"+ name +" From BridgeLabz";
    }

    @GetMapping("/hello/param/{name}")
    public String sayHelloPath(@PathVariable String name){
        return "Hello "+ name +" From BridgeLabz";
    }

    @PostMapping("/hello/post")
    public String sayHelloPost(@RequestBody UserDTO userDTO){
        return "Hello "+ userDTO.getFirstName() + " "+ userDTO.getLastName() + " "+ " From Bridglabz";

    }

    @PutMapping("/hello/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName,
                              @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
