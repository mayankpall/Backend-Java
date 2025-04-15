package com.bridgelabz.greeting_app.service;


import com.bridgelabz.greeting_app.Greeting;
import com.bridgelabz.greeting_app.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "hello world";
    }


    public String getPersonalizedMessage (String firstName, String lastName){
        if(firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()){
            return "Hello " + firstName + " " + lastName + " " ;
        }
        else if (firstName != null && !firstName.isEmpty()){
            return "Hello "+ firstName;
        }
        else if(lastName != null && !lastName.isEmpty()){
            return "Hello "+ lastName;
        }
        else {
            return "HELLO WORLD";
        }
    }

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveData(Greeting greeting){
        return greetingRepository.save(greeting);
    }

    public Optional<Greeting> findGreetingbyId(Long id){
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreeting (){
        return greetingRepository.findAll();
    }

    public Optional<Greeting> updateGreeting(long id , String newMessage){
        Optional<Greeting> optionalMessage = greetingRepository.findById(id);

        if(optionalMessage.isPresent()){
            Greeting greeting = optionalMessage.get();
            greeting.setMessage(newMessage);
            greetingRepository.save(greeting);
            return Optional.of(greeting);
        }
        else {
            return Optional.empty();
        }
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
