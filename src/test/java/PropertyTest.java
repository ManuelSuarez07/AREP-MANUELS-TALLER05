import com.eci.AREP_TALLER05_MANUELS.ApplicationProperty;
import com.eci.AREP_TALLER05_MANUELS.controller.PropertyController;
import com.eci.AREP_TALLER05_MANUELS.model.Property;
import com.eci.AREP_TALLER05_MANUELS.service.PropertyService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
 
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.springframework.http.HttpStatus.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
 
@SpringBootTest(classes = ApplicationProperty.class)
@ExtendWith(SpringExtension.class)
class PropertyTest {
 
    @Autowired
    private PropertyService propertyService;
 
    @Autowired
    private PropertyController propertyController;
 
    private Property property;
 
    @BeforeEach
    void setUp() {
        property = new Property();
        property.setId(1L);
        property.setAddress("Calle 100");
        property.setPrice(1250000.0);
        property.setSize(90.0);
        property.setDescription("AutoNorte");
    }
 
 
    @Test
    void testCreateProperty() {
        ResponseEntity<Property> response = propertyController.createProperty(property);
        assertEquals(CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }
 
    @Test
    void testGetPropertyByIdNotFound() {
        ResponseEntity<Property> response = propertyController.getPropertyById(99L); // ID que no existe
        assertEquals(NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testSaveProperty() {
        Property savedProperty = propertyService.saveProperty(property);
        assertNotNull(savedProperty);
        assertEquals("Calle 100", savedProperty.getAddress());
    }

 
    @Test
    void testGetPropertyById() {
        Optional<Property> foundProperty = propertyService.getPropertyById(1L);
        assertTrue(foundProperty.isPresent());
    }
}