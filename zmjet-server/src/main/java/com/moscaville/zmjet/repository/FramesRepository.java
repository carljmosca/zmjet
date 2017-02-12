/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.zmjet.repository;

import com.carljmosca.zmjet.entity.Frames;
import com.carljmosca.zmjet.entity.FramesPK;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author moscac
 */
@RepositoryRestResource(collectionResourceRel = "frames", path = "frames")
public interface FramesRepository extends PagingAndSortingRepository<Frames, FramesPK> {

    /**
     *
     * @param t
     */
    @Override
    @RestResource(exported = false)
    public void delete(Frames t);
}

