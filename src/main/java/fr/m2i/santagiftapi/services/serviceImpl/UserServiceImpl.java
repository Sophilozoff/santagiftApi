package fr.m2i.santagiftapi.services.serviceImpl;

import fr.m2i.santagiftapi.models.User;
import fr.m2i.santagiftapi.repositories.UserRepository;
import fr.m2i.santagiftapi.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements GenericService<User> {

    private final UserRepository userRepository;

    @Override
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
