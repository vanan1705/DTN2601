package com.vti.testing.Repository;

import com.vti.testing.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {
}
