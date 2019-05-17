package com.example.jpademo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.config.BootstrapMode

@Configuration
@EnableJpaRepositories(basePackages = ["com.example.jpademo.repositories"], bootstrapMode = BootstrapMode.LAZY)
class RepositoryConfig {

}
