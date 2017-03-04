/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.zmjet.repository;

import com.github.carljmosca.zmjet.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author moscac
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
    public Users findByUsername(String username);
    
}
