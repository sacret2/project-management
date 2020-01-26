package com.jrp.pma.dao;

import com.jrp.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);
}
