package it.ddalpra.acme.logisticApp.item.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import it.ddalpra.acme.logisticApp.item.entity.Item;
import it.ddalpra.acme.logisticApp.item.service.ItemService;

@RestController
@RequestMapping("/api/v1/items") // È buona pratica versionare le API
public class ItemController {

    private final ItemService itemService;

    // Iniezione tramite costruttore della sola dipendenza necessaria
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Questo metodo lista gli articoli presenti nel db.
     * @return
     */
    @GetMapping("/listall")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable UUID id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable UUID id, @RequestBody Item itemDetails) {
        Item updatedItem = itemService.updateItem(id, itemDetails);
        return ResponseEntity.ok(updatedItem);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable UUID id) {
        itemService.deleteItem(id);
    }

}