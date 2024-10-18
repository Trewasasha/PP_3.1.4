package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAllRole();

    void saveRole(Role roleAdmin);

    Optional<Role> findByIdRole(long roles);
}
