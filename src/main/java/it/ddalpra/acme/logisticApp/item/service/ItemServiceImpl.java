package it.ddalpra.acme.logisticApp.item.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import it.ddalpra.acme.logisticApp.item.controller.ResourceNotFoundException;
import it.ddalpra.acme.logisticApp.item.dao.ItemRepository;
import it.ddalpra.acme.logisticApp.item.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(UUID id) {
        return itemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
    }

    @Override
    public Item createItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    @Override
    public Item updateItem(UUID id, Item item) {
        Item existingItem = getItemById(id); // Riusiamo il metodo già esistente
        existingItem.setCodeItem(item.getCodeItem());
        existingItem.setModificationUser(item.getModificationUser());
        existingItem.setDescription(item.getDescription());
        existingItem.setBarcode(item.getBarcode());
        existingItem.setCodeFamily(item.getCodeFamily());
        existingItem.setWeight(item.getWeight());
        existingItem.setVolume(item.getVolume());
        existingItem.setUnitOfMeasure(item.getUnitOfMeasure());
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(UUID id) {
        Item itemToDelete = getItemById(id); // Riusiamo il metodo per verificare l'esistenza
        itemRepository.delete(itemToDelete);
    }
}