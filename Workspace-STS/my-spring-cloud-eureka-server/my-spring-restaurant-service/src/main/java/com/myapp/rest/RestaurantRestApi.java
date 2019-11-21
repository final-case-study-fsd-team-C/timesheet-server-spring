package com.myapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.MenuItem;
import com.myapp.model.Restaurant;
import com.myapp.service.MenuItemService;
import com.myapp.service.RestaurantService;

@RestController
@RequestMapping("/api")
public class RestaurantRestApi {
    RestaurantService restaurantService;
    MenuItemService menuItemService;

    @Autowired
    public RestaurantRestApi(RestaurantService restaurantService, MenuItemService menuItemService) {
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Restaurant findRestaurant(@RequestParam(value = "name") String name) {
        return restaurantService.getRestaurantByName(name);
    }

    @RequestMapping(value = "/restaurants/{rid}/menuItems", method = RequestMethod.GET)
    public List<MenuItem> getMenuItems(@PathVariable String rid) {
        return menuItemService.findAllByRestaurantId(rid);
    }

    @RequestMapping(value = "/restaurants/{rid}/menuItems", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
    }

    @RequestMapping(value = "/restaurants/bulk/menuItems", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItems) {
        this.menuItemService.uploadMenuItems(menuItems);
    }
}
