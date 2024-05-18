package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    @Test
    public void testCreate() {
        ClothingBrandController controller = new ClothingBrandController(); // Nutzen Sie die richtige Klasse
        ToDo todo = new ToDo(1, "Test", "Dies ist ein Test-Todo");
        controller.createTodo(1, todo); // Stellen Sie sicher, dass diese Methode in ClothingBrandController definiert ist
        assertEquals(1, controller.count()); // Annahme: Diese Methode zählt alle Objekte (sowohl ClothingBrands als auch ToDos)
        assertEquals(1, controller.todo().size()); // Stellen Sie sicher, dass diese Methode die ToDo-Liste zurückgibt
    }
}
