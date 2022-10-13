package moe.cachapa.android.mvvm.template.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import moe.cachapa.android.mvvm.template.data.db.dao.MovieDetailDao
import moe.cachapa.android.mvvm.template.data.db.dao.MovieItemDao
import moe.cachapa.android.mvvm.template.data.db.dao.VideoDao
import moe.cachapa.android.mvvm.template.data.db.entity.MovieDetailEntity
import moe.cachapa.android.mvvm.template.data.db.entity.MovieItemEntity
import moe.cachapa.android.mvvm.template.data.db.entity.VideoEntity

@Database(
    entities = [
        MovieDetailEntity::class,
        MovieItemEntity::class,
        VideoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AndroidMVVMTemplateDatabase: RoomDatabase() {

    //DAOs
    abstract fun getMovieDetailDao(): MovieDetailDao
    abstract fun getMovieItemDao(): MovieItemDao
    abstract fun getVideoDao(): VideoDao

    companion object {
        @Volatile
        private var instance: AndroidMVVMTemplateDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                // if there is no instance, build a database (buildDatabase(context))
                // and also, whatever is returned from the builder, set the instance equal to "it"
                instance
                    ?: buildDatabase(
                        context
                    ).also {
                        instance = it
                    }
            }

        // We create a function to build the database, which will receive the application context
        // /This builder will initialize the database java class for the app (_root_ide_package_.tech.alphas.tellmeatale.data.db.AndroidMVVMTemplateDatabase)
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AndroidMVVMTemplateDatabase::class.java, "telltale.db"
            ).fallbackToDestructiveMigration().build()
    }

}