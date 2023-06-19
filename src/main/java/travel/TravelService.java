package travel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository repository;

    public List<Travel> getAll() {
        return repository.findAll();
    }

    public Travel getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The id " + id + " cannot be found"));
    }

    public Travel create(Travel travel) {
        return repository.save(travel);
    }

    public Travel update(Travel travel, Long id) {
        Travel foundTravel = getById(id);

        foundTravel.setTitle(travel.getTitle());
        foundTravel.setDescription(travel.getDescription());
        foundTravel.setTravelList(travel.getTravelList());

        return repository.save(foundTravel);
    }

    public void delete(Long id) {
    }
}
