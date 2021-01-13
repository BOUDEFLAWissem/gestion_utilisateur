package com.example.gestion_users.Repositories;

import com.example.gestion_users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

public interface UserRepository extends CrudRepository< User, Long> {

    @Query("select u from User u where u.nom LIKE %:nom%")
     List<User> findByNom( @Param("nom") String nom);



    @Query("select u from User u where u.nom LIKE %:nom%")
    User findUserByNom( @Param("nom") String nom);
    //@Query("select u from User u where u.nom = :nom")
    //User findByNom ( @Param("nom") String nom);

    //User findUserByNom(String g);




}
