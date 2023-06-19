package travel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import place.Place;

import java.util.List;

@RestController
@RequestMapping("/travels")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService service;

    @GetMapping("/all")
    public List<Travel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Travel getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public Travel create(@RequestBody Travel travel) {
        return service.create(travel);
    }

    @PutMapping("/update/{id}")
    public Travel update(@RequestBody Travel travel, @PathVariable("id") Long id) {
        return service.update(travel, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
