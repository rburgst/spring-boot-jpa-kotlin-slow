package com.example.jpademo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.example.jpademo.repositories"])
class RepositoryConfig {

}
