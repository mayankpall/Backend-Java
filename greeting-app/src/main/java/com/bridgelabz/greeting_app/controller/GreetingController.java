package com.bridgelabz.greeting_app.controller;

import com.bridgelabz.greeting_app.Greeting;
import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        String message = greetingService.getPersonalizedMessage(firstName, lastName);
        return new Greeting(message);
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        String message = "Hello from POST! Received: " + greeting.getMessage();
        return new Greeting(message);
    }

    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        String message = "Hello from PUT! Updated to: " + greeting.getMessage();
        return new Greeting(message);
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        String message = greetingService.getGreetingMessage() + " has been deleted!";
        return new Greeting(message);
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting){
        return greetingService.saveData(greeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id){
        Optional<Greeting> optionalGreeting = greetingService.findGreetingbyId(id);

        return optionalGreeting.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Greeting> listAllGreeting(){
        return greetingService.getAllGreeting();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Greeting> editGreeting(@PathVariable Long id, @RequestBody Greeting greeting){
        Optional<Greeting> optionalGreeting = greetingService.updateGreeting(id,greeting.getMessage());
        return optionalGreeting.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
