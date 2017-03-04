/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.zmjet.controller;

import com.github.carljmosca.zmjet.entity.Events;
import com.github.carljmosca.zmjet.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moscac
 */

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventsRepository framesRepository;

    @Autowired
    EventsController(EventsRepository framesRepository) {
        this.framesRepository = framesRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Page<Events> readEventss(Pageable pageable) {
        return this.framesRepository.findAll(pageable);
    }
    
}
