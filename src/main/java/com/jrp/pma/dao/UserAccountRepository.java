package com.jrp.pma.dao;

import com.jrp.pma.entities.authentication.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);
}
