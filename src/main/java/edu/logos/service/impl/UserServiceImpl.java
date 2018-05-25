package edu.logos.service.impl;

import edu.logos.dto.filter.RockyFilter;
import edu.logos.entity.User;
import edu.logos.entity.UserImages;
import edu.logos.repository.UserRepository;
import edu.logos.service.UserService;
import edu.logos.service.utils.CustomFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByID(int id) throws Exception {
        User user = userRepository.getOne(id);
//        String folderPath = CustomFileUtils.getFolderPath("test");
//        user.getUserImages().setImageName(folderPath + "Default.png");
        saveUser(user);

        return user;
    }

    @Override
    public Page<User> findUserByPAge(Pageable pageable) {
        return userRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    @Override
    public List<User> findAllByFilter(RockyFilter filter) {
        return userRepository.findAll(getSpecification(filter));
    }

    @Override
    public Page<User> findUsersByPage(Pageable pageable, RockyFilter filter) {
        return userRepository.findAll(getSpecification(filter), PageRequest.of(pageable.getPageNumber(), filter.getPageSize()));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private Specification<User> getSpecification(RockyFilter filter) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                final Collection<Predicate> predList = new ArrayList<>();
                for (String t : String.valueOf(filter.toString()).split(" ")) {
                    RockyFilter flt = new RockyFilter();
                    flt.setSearch(t);
                    predList.add(criteriaBuilder.like(root.get("firstName"), '%' + flt.getSearch().toString() + '%'));
                    predList.add(criteriaBuilder.like(root.get("lastName"), '%' + flt.getSearch().toString() + '%'));
                }
                return criteriaBuilder.and(criteriaBuilder.or(predList.toArray(new Predicate[predList.size()])),
                            criteriaBuilder.between(root.get("salary"),filter.getMinValue(),filter.getMaxValue()));
            }
        };
    }
}
