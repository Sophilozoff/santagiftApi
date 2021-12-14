package fr.m2i.santagiftapi.services.serviceImpl;

import fr.m2i.santagiftapi.models.Child;
import fr.m2i.santagiftapi.repositories.ChildRepository;
import fr.m2i.santagiftapi.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("childService")
@Transactional
@RequiredArgsConstructor
public class ChildServiceImpl implements GenericService<Child> {

    private final ChildRepository childRepository;

    @Override
    public List findAll() {
        return childRepository.findAll();
    }

    @Override
    public Child findById(Long id) {
        return childRepository.findById(id).get();
    }

    @Override
    public Child save(Child entity) {
        return childRepository.save(entity);
    }

    @Override
    public Child update(Child entity) {
        return childRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        childRepository.deleteById(id);
    }

}
