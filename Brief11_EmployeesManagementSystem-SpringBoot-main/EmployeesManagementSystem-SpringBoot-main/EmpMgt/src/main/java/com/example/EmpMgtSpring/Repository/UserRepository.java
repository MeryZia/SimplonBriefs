package com.example.EmpMgtSpring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.EmpMgtSpring.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {
 
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
