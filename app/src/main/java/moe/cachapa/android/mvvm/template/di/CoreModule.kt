package moe.cachapa.android.mvvm.template.di

import moe.cachapa.android.mvvm.template.di.modules.* // ktlint-disable no-wildcard-imports
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

object CoreModule {
    private val modules: List<Module>
        get() = listOf(
            networkModule,
            repositoryModule,
            localModule,
            databaseModule,
            serviceModule,
            workerModule,
            viewModelModule,
            dataModule,
            utilsModule
        )

    fun init() = loadKoinModules(modules)
}
