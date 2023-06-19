package place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;

    public List<Place> getAll() {
        return repository.findAll();
    }

    public Place getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The id " + id + " cannot be found"));
    }

    public Place create(Place place) {
        return  repository.save(place);
    }

    public Place update(Place place, Long id) {
        Place foundPlace = getById(id);

        foundPlace.setPlace(place.getPlace());
        foundPlace.setPlace(place.getPlace());

        return repository.save(foundPlace);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
