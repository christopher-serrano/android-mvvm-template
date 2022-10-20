package moe.cachapa.android.mvvm.template.di.modules

import android.content.Context
import moe.cachapa.android.mvvm.template.data.db.AndroidMVVMTemplateDatabase
import moe.cachapa.android.mvvm.template.data.db.dao.MovieDetailDao
import moe.cachapa.android.mvvm.template.data.db.dao.MovieItemDao
import moe.cachapa.android.mvvm.template.data.db.dao.VideoDao
import moe.cachapa.android.mvvm.template.data.mappers.*
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

    factory { MovieDetailMapper() }
    factory { MovieDetailEntityMapper() }
    factory { MovieItemMapper() }
    factory { MovieItemEntityMapper() }
    factory { VideoMapper() }
    factory { VideoEntityMapper() }

}

val databaseModule = module {

    //Bind Database
    single { AndroidMVVMTemplateDatabase.invoke(androidContext()) }

    //Provide DAOs
    fun provideMovieDetailDao(database: AndroidMVVMTemplateDatabase): MovieDetailDao {
        return database.getMovieDetailDao()
    }

    fun provideMovieItemDao(database: AndroidMVVMTemplateDatabase): MovieItemDao {
        return database.getMovieItemDao()
    }

    fun provideVideoDao(database: AndroidMVVMTemplateDatabase): VideoDao {
        return database.getVideoDao()
    }

    // Bind DAOs
    single { provideMovieDetailDao(get()) }
    single { provideMovieItemDao(get()) }
    single { provideVideoDao(get()) }
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