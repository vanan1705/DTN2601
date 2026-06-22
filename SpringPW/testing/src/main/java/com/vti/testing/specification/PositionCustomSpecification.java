package com.vti.testing.specification;

import com.vti.testing.entity.Position;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class PositionCustomSpecification implements Specification<Position> {
    private String field;

    private Object value;

    @Override
    public Predicate toPredicate(Root<Position> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("name")){
            return criteriaBuilder.like(root.get("name"),"%"+value+"%");
        }
        return null;
    }
}
