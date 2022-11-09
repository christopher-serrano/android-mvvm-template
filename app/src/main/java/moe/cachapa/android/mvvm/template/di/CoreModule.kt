package moe.cachapa.android.mvvm.template.di

import moe.cachapa.android.mvvm.template.di.modules.*
import org.koin.core.context.loadKoinModules

object CoreModule {
    private val modules =
        listOf(
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
