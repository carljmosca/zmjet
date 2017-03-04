/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.zmjet.controller;

import com.github.carljmosca.zmjet.entity.Monitors;
import com.github.carljmosca.zmjet.repository.MonitorsRepository;
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
@RequestMapping("/monitors")
public class MonitorsController {

    private final MonitorsRepository monitorsRepository;

    @Autowired
    MonitorsController(MonitorsRepository monitorsRepository) {
        this.monitorsRepository = monitorsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Page<Monitors> readMonitorss(Pageable pageable) {
        return this.monitorsRepository.findAll(pageable);
    }
}
