package com.vti.testing.specification;

import com.vti.testing.entity.Account;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class AccountCustomSpecification implements Specification<Account> {

    private String field;

    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("userName")){
            return criteriaBuilder.like(root.get("userName"),"%"+value+"%");
        }
        if(field.equalsIgnoreCase("fullName")){
            return criteriaBuilder.like(root.get("fullName"),"%"+value+"%");
        }
        if(field.equalsIgnoreCase("email")){
            return criteriaBuilder.like(root.get("email"),"%"+value+"%");
        }
        if(field.equalsIgnoreCase("departmentName")){
            return criteriaBuilder.like(root.get("department").get("name"),"%"+value+"%");
        }
        if(field.equalsIgnoreCase("positionName")){
            return criteriaBuilder.like(root.get("position").get("name"),"%"+value+"%");
        }

        return null;
    }
}
