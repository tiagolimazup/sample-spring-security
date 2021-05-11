package br.com.zup.orange.samplesec

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.context.support.WithUserDetails
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloResourceTest {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	fun test() {
		mockMvc.get("/hello") {
					with(httpBasic("tiago.lima@zup.com.br", "123456"))
				}
				.andExpect {
					status {
						isOk()
					}
					content {
						string("Hello, tiago.lima@zup.com.br")
					}
				}
	}

}
