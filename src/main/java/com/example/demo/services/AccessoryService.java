package com.example.demo.services;

import com.example.demo.models.Accessory;
import com.example.demo.repositories.AccessoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Lavet af Joakim
@Service
public class AccessoryService {

    @Autowired
    AccessoryRepo accessoryRepo;

    public Accessory fetchAccessoryById(int id) {
        return accessoryRepo.fetchAccessoryById(id);
    }

    public List<Accessory> fetchAllAccessories() {
        return accessoryRepo.fetchAllAccessories();
    }

    public void createAccessory(Accessory a) {
        accessoryRepo.createAccessory(a);
    }

    public void updateAccessory(Accessory a) {
        accessoryRepo.updateAccessory(a);
    }

    public void deleteAccessory(int id) {
        accessoryRepo.deleteAccessory(id);
    }

    public List<String> fetchAllAccessoryNames() {
        return accessoryRepo.fetchAllAccessoryNames();
    }

    public List<String> fetchAllChosenAccessoriesById(int reservation_id) {
        return accessoryRepo.fetchAllChosenAccessoriesById(reservation_id);
    }

    public void createAccessoryForReservation(int id, String name) {
        accessoryRepo.createAccessoryForReservation(id, name);
    }

    public void deleteAccessoryInReservation(int id) {
        accessoryRepo.deleteAccessoryInReservation(id);
    }

    // Methods used for checking for duplicates
    public boolean checkForDuplicateAccessoryName(String accessory_name) {
        List<String> accessoryNameList = accessoryRepo.fetchAccessoryNameFromAccessory();
        return accessoryNameList.contains(accessory_name);
    }

    public boolean checkForOtherDuplicateAccessoryName(String accessory_name, int id) {
        List<String> accessoryNameList = accessoryRepo.fetchAccessoryNameFromOtherAccessory(id);
        return accessoryNameList.contains(accessory_name);
    }
}