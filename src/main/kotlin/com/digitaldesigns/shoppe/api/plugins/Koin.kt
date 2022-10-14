package com.digitaldesigns.shoppe.api.plugins

import com.digitaldesigns.shoppe.api.appModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.logger.SLF4JLogger

fun configureKoin(module: Module = appModule) {
    startKoin {
        SLF4JLogger()
        modules(module)
    }
}
