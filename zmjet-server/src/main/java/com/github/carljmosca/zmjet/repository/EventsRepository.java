/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.zmjet.repository;

import com.github.carljmosca.zmjet.entity.Events;
import com.github.carljmosca.zmjet.entity.EventsPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author moscac
 */
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventsRepository extends PagingAndSortingRepository<Events, EventsPK> {  
    
    @Query("select e from Events e where e.eventsPK.monitorId = :monitorId order by startTime desc ")
    Page<Events> findByMonitorId(Pageable pageable, @Param("monitorId") Integer monitorId);

    /**
     *
     * @param t
     */
    @Override
    @RestResource(exported = false)
    public void delete(Events t);
}
