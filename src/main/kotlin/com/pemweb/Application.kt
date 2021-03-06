package com.pemweb

import com.pemweb.plugins.configureRouting
import com.pemweb.plugins.configureSerialization
import com.pemweb.di.controllerModule
import com.pemweb.di.databaseModule
import com.pemweb.di.repositoryModule
import com.pemweb.di.routeModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.util.*
import org.koin.core.logger.Level
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

@InternalAPI
@KtorExperimentalLocationsAPI
fun main() {
	embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
		install(CORS) {
			anyHost()
			method(HttpMethod.Get)
			method(HttpMethod.Post)
			method(HttpMethod.Options)
			method(HttpMethod.Put)
			method(HttpMethod.Delete)
			header(HttpHeaders.ContentType)
		}
		install(Koin) {
			slf4jLogger(Level.ERROR)
			modules(listOf(databaseModule, repositoryModule, controllerModule, routeModule))
		}
		install(Locations)
		configureRouting()
		configureSerialization()
	}.start(wait = true)
}
