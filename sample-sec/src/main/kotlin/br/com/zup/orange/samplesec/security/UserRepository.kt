package br.com.zup.orange.samplesec.security

import org.springframework.data.repository.Repository

interface UserRepository : Repository<User, Long> {

    fun findByLogin(username: String): User?

}
