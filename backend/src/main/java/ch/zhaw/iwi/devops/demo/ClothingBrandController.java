package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClothingBrandController {

    private Map<Integer, ClothingBrand> brands = new HashMap<Integer, ClothingBrand>();
    private Map<Integer, ToDo> todos = new HashMap<>();  // Zusätzliche Verwaltung für ToDo-Objekte




    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.brands.put(1, new ClothingBrand(1, "Luxus Fashion", "Exklusive Designerkleidung"));
        this.brands.put(2, new ClothingBrand(2, "Street Trends", "Moderne Streetwear und Accessoires"));
        this.brands.put(3, new ClothingBrand(3, "Classic Wears", "Klassische und zeitlose Stücke"));
        System.out.println("Init Data");
    }

    @GetMapping("/test")
    public String test() {
        return "ClothingBrand app is up and running!";
    }

    @GetMapping("/services/ping")
    public String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/count")
    public int count() {
        return this.brands.size();
    }

    @GetMapping("/services/clothingbrand")
    public List<PathListEntry<Integer>> clothingbrand() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var brand : this.brands.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(brand.getId(), "brandKey");
            entry.setName(brand.getName());
            entry.getDetails().add(brand.getDescription());
            entry.setTooltip(brand.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/clothingbrand/{key}")
    public ClothingBrand getClothingBrand(@PathVariable Integer key) {
        return this.brands.get(key);
    }

    @PostMapping("/services/clothingbrand")
    public void createClothingBrand(@RequestBody ClothingBrand brand) {
        var newId = this.brands.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        brand.setId(newId);
        this.brands.put(newId, brand);
    }

    @PutMapping("/services/clothingbrand/{id}")
    public void updateClothingBrand(@PathVariable Integer id, @RequestBody ClothingBrand brand) {
        brand.setId(id);
        this.brands.put(id, brand);
    }

    @DeleteMapping("/services/clothingbrand/{key}")
    public ClothingBrand deleteClothingBrand(@PathVariable Integer key) {
        return this.brands.remove(key);
    }
    @PostMapping("/todos")
    public void createTodo(@RequestBody ToDo todo) {
        int newId = todos.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        todo.setId(newId);
        todos.put(newId, todo);
    }

    @GetMapping("/todos")
    public List<ToDo> todo() {
        return new ArrayList<>(todos.values());
    }

    @GetMapping("/count")
    public int count() {
        return this.brands.size() + this.todos.size();  // Zählt sowohl Clothing Brands als auch ToDos
    }
}
