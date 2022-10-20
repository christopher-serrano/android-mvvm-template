package moe.cachapa.android.mvvm.template.data.db.dao

import androidx.room.*
import moe.cachapa.android.mvvm.template.data.db.entity.BaseEntity
import moe.cachapa.android.mvvm.template.data.db.entity.MovieItemEntity

@Dao
interface MovieItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: MovieItemEntity?): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: MovieItemEntity?)

    @Transaction
    suspend fun upsert(entity: MovieItemEntity?) {
        val id: Long = insert(entity)
        if (id == -1L)
            update(entity)
    }

    @Query("SELECT * FROM movie_item WHERE id = :id")
    suspend fun fetch(id: Int): MovieItemEntity?

    @Query("SELECT * FROM movie_item")
    suspend fun fetchAll(): List<MovieItemEntity>?

    @Query("SELECT * FROM movie_item WHERE list_type = :itemType")
    suspend fun fetchAllByType(itemType: BaseEntity.MovieListType): List<MovieItemEntity>?

    @Query("DELETE FROM movie_item WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM movie_item")
    suspend fun delete()

    @Transaction
    suspend fun purge() {
        val list = fetchAll()
        if (!list.isNullOrEmpty())
            delete()
    }
}