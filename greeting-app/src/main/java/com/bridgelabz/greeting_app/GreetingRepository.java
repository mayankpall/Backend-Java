package com.bridgelabz.greeting_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GreetingRepository extends JpaRepository<Greeting, Long> {

}
