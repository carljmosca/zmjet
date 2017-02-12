/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.zmjet.repository;

import com.carljmosca.zmjet.entity.Events;
import com.carljmosca.zmjet.entity.EventsPK;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author moscac
 */
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventsRepository extends PagingAndSortingRepository<Events, EventsPK> {

    /**
     *
     * @param t
     */
    @Override
    @RestResource(exported = false)
    public void delete(Events t);
}
