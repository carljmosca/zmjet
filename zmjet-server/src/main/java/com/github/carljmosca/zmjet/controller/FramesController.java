/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.zmjet.controller;

import com.github.carljmosca.zmjet.entity.Frames;
import com.github.carljmosca.zmjet.repository.FramesRepository;
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
@RequestMapping("/frames")
public class FramesController {

    private final FramesRepository framesRepository;

    @Autowired
    FramesController(FramesRepository framesRepository) {
        this.framesRepository = framesRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Page<Frames> readFramess(Pageable pageable) {
        return this.framesRepository.findAll(pageable);
    }

    
}
