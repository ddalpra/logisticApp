package it.ddalpra.acme.logisticApp.item.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ddalpra.acme.logisticApp.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {

}
