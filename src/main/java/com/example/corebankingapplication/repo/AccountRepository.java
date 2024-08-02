package com.example.corebankingapplication.repo;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.corebankingapplication.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    /* Search query */
    @Query("select a from Account a where " +
            "lower(a.accountType) like concat('%', lower(?1) , '%') or " +
            "concat(a.id,'') like concat('%', ?1 , '%') or " +
            "concat(a.balance,'') like concat('%', ?1 , '%') or " +
            "lower(a.customer.firstName) like concat('%', lower(?1) , '%') or " +
            "lower(a.customer.lastName) like concat('%', lower(?1) , '%')")
    List<Account> search(String searchString);

}
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corebankingapplication.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

    
} 
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
