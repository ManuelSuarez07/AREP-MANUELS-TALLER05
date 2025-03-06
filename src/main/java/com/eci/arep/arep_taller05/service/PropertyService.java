package com.eci.arep.arep_taller05.service;

import com.eci.arep.arep_taller05.model.Property;
import com.eci.arep.arep_taller05.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

 
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }


    public Optional<Property> getPropertyById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        System.out.println("¿Propiedad encontrada? " + property.isPresent());
        return property;
    }



    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

 
    public Property updateProperty(Long id, Property property) {
    Optional<Property> existingProperty = propertyRepository.findById(id);
    if (existingProperty.isPresent()) {
        Property updatedProperty = existingProperty.get();
        updatedProperty.setAddress(property.getAddress());
        updatedProperty.setPrice(property.getPrice());
        updatedProperty.setSize(property.getSize());
        updatedProperty.setDescription(property.getDescription());
        updatedProperty.setPhone(property.getPhone());
        return propertyRepository.save(updatedProperty);
    } else {
        throw new RuntimeException("Property not found with id " + id);
    }
}



    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
