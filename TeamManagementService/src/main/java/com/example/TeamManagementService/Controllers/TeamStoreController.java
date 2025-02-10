package com.example.TeamManagementService.Controllers;


import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/team/items")
public class TeamStoreController {

    @Autowired
    private ItemRepository itemRepository;

    // Get all available items in the store
    @GetMapping
    public List<AbstractReadWriteAccess.Item> getAllItems() {
        return itemRepository.findAll();
    }
}
