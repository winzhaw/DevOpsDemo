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

    private Map<Integer, ClothingBrand> brands = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        // Init-Methode mit Beispiel-Daten
        this.brands.put(1, new ClothingBrand(1, "Luxus Fashion", "Exklusive Designerkleidung"));
        this.brands.put(2, new ClothingBrand(2, "Street Trends", "Moderne Streetwear und Accessoires"));
        this.brands.put(3, new ClothingBrand(3, "Classic Wears", "Klassische und zeitlose Stücke"));
    }

    @GetMapping("/count")
    public int count() {
        return this.brands.size();  // Zählt nur Clothing Brands
    }

    @GetMapping("/test")
    public String test() {
        return "ClothingBrand app is up and running!";
    }

    @GetMapping("/services/ping")
    public String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1\"}";
    }

    @GetMapping("/services/clothingbrand")
    public List<ClothingBrand> clothingbrand() {
        return new ArrayList<>(this.brands.values());
    }

    @GetMapping("/services/clothingbrand/{id}")
    public ClothingBrand getClothingBrand(@PathVariable Integer id) {
        return this.brands.get(id);
    }

    @PostMapping("/services/clothingbrand")
    public void createClothingBrand(@RequestBody ClothingBrand brand) {
        int newId = this.brands.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        brand.setId(newId);
        this.brands.put(newId, brand);
    }

    @PutMapping("/services/clothingbrand/{id}")
    public void updateClothingBrand(@PathVariable Integer id, @RequestBody ClothingBrand brand) {
        brand.setId(id);
        this.brands.put(id, brand);
    }

    @DeleteMapping("/services/clothingbrand/{id}")
    public ClothingBrand deleteClothingBrand(@PathVariable Integer id) {
        return this.brands.remove(id);
    }
}
