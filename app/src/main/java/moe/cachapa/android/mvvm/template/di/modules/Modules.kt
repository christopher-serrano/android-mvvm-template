package moe.cachapa.android.mvvm.template.di.modules

import android.content.Context
import moe.cachapa.android.mvvm.template.network.api.ApiClient
import moe.cachapa.android.mvvm.template.network.interceptor.ConnectivityInterceptor
import moe.cachapa.android.mvvm.template.network.interceptor.ConnectivityInterceptorImpl
import moe.cachapa.android.mvvm.template.network.interceptor.RequestInterceptor
import moe.cachapa.android.mvvm.template.network.interceptor.RequestInterceptorImpl
import moe.cachapa.android.mvvm.template.repository.MovieRepository
import moe.cachapa.android.mvvm.template.repository.MovieRepositoryImpl
import moe.cachapa.android.mvvm.template.utils.ImageLoader
import moe.cachapa.android.mvvm.template.utils.library.CustomFileUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    //single { SomeApiClient.invoke() }
    //single<SomeInterceptor> { SomeInterceptorImpl(get()) }
    single { ApiClient.invoke() }
    single<ConnectivityInterceptor> { ConnectivityInterceptorImpl(get()) }
    single<RequestInterceptor> { RequestInterceptorImpl() }

}

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl() }
}

val localModule = module {

}

val dataModule = module {
    single { androidContext().getSharedPreferences("Prefs", Context.MODE_PRIVATE) }
}

val databaseModule = module {

    //Bind Database

    //single { SomeDatabase.invoke(androidContext()) }

    //Provide DAOs

    //fun provideSomeDao(database: SomeDatabase): SomeDao {
    //    return database.getSomeDao()
    //}

    // Bind DAOs

    //single { proviceSomeDao(get()) }
}

val serviceModule = module {

    single { CustomFileUtils(get()) }

    //factory { SomeBroadCastReceiver() }
    //single { SomeWorkManager(androidContext()) }
    //factory { SomeWorkRequest() }
}

val workerModule = module {
    //factory { SomePlaceholderWorker(get(), get()) }
}

val viewModelModule = module {
    //viewModel { SomeViewModel(get()) }
}

val utilsModule = module {
    // factory { (context: Context) -> AppLoader(context) }
    factory { ImageLoader(get()) }
}