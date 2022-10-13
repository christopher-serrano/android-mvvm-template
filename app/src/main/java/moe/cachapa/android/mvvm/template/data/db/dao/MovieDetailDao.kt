package moe.cachapa.android.mvvm.template.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import moe.cachapa.android.mvvm.template.data.db.entity.MovieDetailEntity

@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: MovieDetailEntity?): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: MovieDetailEntity?)

    @Transaction
    suspend fun upsert(entity: MovieDetailEntity?) {
        val id: Long = insert(entity)
        if (id == -1L)
            update(entity)
    }

    @Query("SELECT * FROM movie_detail WHERE id = :id")
    suspend fun fetch(id: Int): MovieDetailEntity?

    @Query("SELECT * FROM movie_detail")
    suspend fun fetchAll(): List<MovieDetailEntity>?

    @Query("DELETE FROM movie_detail WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM movie_detail")
    suspend fun delete()

    @Transaction
    suspend fun purge() {
        val list = fetchAll()
        if (!list.isNullOrEmpty())
            delete()
    }
}