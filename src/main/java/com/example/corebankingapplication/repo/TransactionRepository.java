package com.example.corebankingapplication.repo;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9

import com.example.corebankingapplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

<<<<<<< HEAD
    /* Search query */
    @Query("select a from Transaction a where " +
            "lower(a.transType) like concat('%', lower(?1) , '%') or " +
            "concat(a.id,'') like concat('%', ?1 , '%') or " +
            "concat(a.transAmt,'') like concat('%', ?1 , '%') " )
    List<Transaction> search(String searchString);
=======
    
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
} 
