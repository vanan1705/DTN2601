package com.vti.testing.Repository;

import com.vti.testing.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String userName);

    boolean existsByEmailOrUserName(String email, String userName);

    boolean existsByEmailAndIdNot(String email, Integer id);

    boolean existsByUserNameAndIdNot(String userName, Integer id);

}
