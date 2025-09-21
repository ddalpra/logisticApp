package it.ddalpra.acme.logisticApp.item.service;

import java.util.List;
import java.util.UUID;

import it.ddalpra.acme.logisticApp.item.entity.Item;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(UUID id);
    Item createItem(Item item);
    Item updateItem(UUID id, Item item);
    void deleteItem(UUID id);
}
