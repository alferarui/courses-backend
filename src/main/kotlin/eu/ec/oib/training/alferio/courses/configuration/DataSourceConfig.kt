package eu.ec.oib.training.alferio.courses.configuration

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    private var env: Environment? = null

    fun DataSourceConfig(env: Environment?) {
        this.env = env
    }

    // Method to get the current active profile
    private fun getActiveProfile(): String {
        return "default"
        /// val activeProfiles = env!!.activeProfiles
        /// // Return the first active profile if it exists, or "default" if none is set
        /// return if (activeProfiles.size > 0) activeProfiles[0] else "default"
    }

    @Value("\${spring.datasource.oracle.url}")
    private val oracleUrl: String? = null

    @Value("\${spring.datasource.oracle.username}")
    private val oracleUsername: String? = null

    @Value("\${spring.datasource.oracle.password}")
    private val oraclePassword: String? = null

    @Value("\${spring.datasource.oracle.driver-class-name}")
    private val oracleDriverClassName: String? = null

    @Bean(name = ["oracleDataSource"])
    fun oracleDataSource(): DataSource {
        println("oracleDataSource :: Active Profile: " + getActiveProfile()) // For debugging or logging

        /** TODO make it retrieve
         * spring.datasource.oracle.url
         * spring.datasource.oracle.username
         * spring.datasource.oracle.password
         * spring.datasource.oracle.driver
         * from application.properties
         */
        return DataSourceBuilder.create()
            .url(oracleUrl)
            .username(oracleUsername)
            .password(oraclePassword)
            .driverClassName(oracleDriverClassName)
            .build()
    }


    @Value("\${spring.datasource.sqlite.url}")
    private val sqliteUrl: String? = null

    @Value("\${spring.datasource.sqlite.driver-class-name}")
    private val sqliteDriverClassName: String? = null

    // SQLite DataSource
    @Bean(name = ["sqliteDataSource"])
    fun sqliteDataSource(): DataSource {
        println("sqliteDataSource :: Active Profile: " + getActiveProfile()) // For debugging or logging

        return DataSourceBuilder.create()
            .url(sqliteUrl)
            .driverClassName(sqliteDriverClassName)
            .build()
    }

    // Oracle JdbcTemplate
    @Bean(name = ["oracleJdbcTemplate"])
    fun oracleJdbcTemplate(@Qualifier("oracleDataSource") dataSource: DataSource?): JdbcTemplate {
        return JdbcTemplate(dataSource!!)
    }

    // SQLite JdbcTemplate
    @Bean(name = ["sqliteJdbcTemplate"])
    fun sqliteJdbcTemplate(@Qualifier("sqliteDataSource") dataSource: DataSource?): JdbcTemplate {
        return JdbcTemplate(dataSource!!)
    }
}