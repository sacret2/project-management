package com.jrp.pma.services;

import com.jrp.pma.dao.UserAccountRepository;
import com.jrp.pma.entities.UserAccount;
import com.jrp.pma.security.PmaUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


@Service
public class PmaUserDetailsService implements UserDetailsService{
    @Autowired
    UserAccountRepository userAccountRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserAccount> user = userAccountRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found " + userName));

        return user.map(PmaUserDetails::new).get();
    }
}
