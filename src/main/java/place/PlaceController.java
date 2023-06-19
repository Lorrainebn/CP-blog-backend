package place;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;

    @GetMapping("/all")
    public List<Place> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public Place create(@RequestBody Place place) {
        return service.create(place);
    }

    @PutMapping("/update/{id}")
    public Place update(@RequestBody Place place, @PathVariable("id") Long id) {
        return service.update(place, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
