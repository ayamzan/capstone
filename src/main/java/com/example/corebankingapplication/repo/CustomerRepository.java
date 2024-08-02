package com.example.corebankingapplication.repo;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corebankingapplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
<<<<<<< HEAD
    // create a custom query method to search by multiple attributes
    List<Customer> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
=======

>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
    
} 
