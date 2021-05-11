package br.com.zup.orange.samplesec.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class DefaultUserDetailsService(val usersRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userDetails: UserDetails? = usersRepository.findByLogin(username)?.let { DefaultUserDetails(it) }
        return userDetails ?: throw UsernameNotFoundException("Username $username not found.")
    }
}