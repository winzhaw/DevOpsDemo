package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClothingBrandControllerTest {
    
    @Test
    public void testCreate() {
        ClothingBrandController controller = new ClothingBrandController();
        ClothingBrand brand = new ClothingBrand(1, "Test Brand", "Test Description");
        controller.createClothingBrand(brand);
        assertEquals(1, controller.count(), "Es sollte genau eine Marke registriert sein.");
        assertEquals("Test Brand", controller.getClothingBrand(1).getName(), "Der Name der Marke sollte 'Test Brand' sein.");
    }

    @Test
    public void testDelete() {
    ClothingBrandController controller = new ClothingBrandController();
    ClothingBrand brand = new ClothingBrand(2, "Test Brand 2", "Test Description 2");
    controller.createClothingBrand(brand);
    assertEquals(1, controller.count(), "Es sollte eine Marke vor dem Löschen registriert sein.");
    controller.deleteClothingBrand(2);
    assertEquals(1, controller.count(), "Es sollte keine Marke nach dem Löschen registriert sein.");
}

}
