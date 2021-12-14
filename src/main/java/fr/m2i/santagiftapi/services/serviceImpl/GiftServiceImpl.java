package fr.m2i.santagiftapi.services.serviceImpl;

import fr.m2i.santagiftapi.models.Gift;
import fr.m2i.santagiftapi.repositories.GiftRepository;
import fr.m2i.santagiftapi.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("giftService")
@Transactional
@RequiredArgsConstructor
public class GiftServiceImpl implements GenericService<Gift> {

    private final GiftRepository giftRepository;

    @Override
    public List<Gift> findAll() {
        return giftRepository.findAll();
    }

    @Override
    public Gift findById(Long id) {
        return giftRepository.findById(id).get();
    }

    @Override
    public Gift save(Gift entity) {
        return giftRepository.save(entity);
    }

    @Override
    public Gift update(Gift entity) {
        return giftRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        giftRepository.deleteById(id);
    }
}
