package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;


import java.util.*;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleDAO;

    @Autowired
    public RoleServiceImpl(RoleRepository roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDAO.findAll();
    }


    public Optional<Role> findByIdRole(long roles) {
        return roleDAO.findAllById(roles);

    }

}
