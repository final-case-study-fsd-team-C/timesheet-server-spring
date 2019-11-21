package com.myapp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.myapp.model.MenuItem;

@RepositoryRestResource(collectionResourceRel = "menuitems")
public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String> {
    @RestResource(rel = "by-rid", description = @Description("Get all menuitems by restaurant id"))
    public List<MenuItem> findAllByRestaurantId(String rid);

    @RestResource(rel = "by-name", description = @Description("Get menuitem by item name"))
    public MenuItem findByName(@Param("name") String name);
}
