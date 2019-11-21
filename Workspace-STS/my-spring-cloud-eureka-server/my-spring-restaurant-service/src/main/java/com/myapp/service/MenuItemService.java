package com.myapp.service;

import java.util.List;

import com.myapp.model.MenuItem;

public interface MenuItemService {
    List<MenuItem> findAllByRestaurantId(String rid);
    void createMenuItem(MenuItem menuItem);
    void uploadMenuItems(List<MenuItem> menuItems);
}
