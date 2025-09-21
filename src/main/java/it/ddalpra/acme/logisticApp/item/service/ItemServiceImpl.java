package it.ddalpra.acme.logisticApp.item.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import it.ddalpra.acme.logisticApp.item.dao.ItemRepository;
import it.ddalpra.acme.logisticApp.item.entity.Item;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(UUID id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public Item createItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    @Override
    public Item updateItem(UUID id, Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if(existingItem.isPresent()){
            Item updatedItem = existingItem.get();
            updatedItem.setCodeItem(item.getCodeItem());
            updatedItem.setDescription(item.getDescription());
            updatedItem.setBarcode(item.getBarcode());
            updatedItem.setCodeFamily(item.getCodeFamily());
            updatedItem.setWeight(item.getWeight());
            updatedItem.setVolume(item.getVolume());
            itemRepository.save(updatedItem);
            return updatedItem;
        } else {
            return null;    
        } 
    }

    @Override
    public void deleteItem(UUID id) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.delete(item.get());
        }   
    }
}