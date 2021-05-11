package br.com.zup.orange.samplesec.security

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User as SpringUser

class DefaultUserDetails(user: User) :
        SpringUser(user.login, user.password, listOf(SimpleGrantedAuthority("USER"))) {

}
