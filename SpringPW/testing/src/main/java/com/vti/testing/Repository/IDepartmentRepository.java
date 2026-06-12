package com.vti.testing.Repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);

    boolean existsByNameAndIdNot(String name, Integer id);
}
