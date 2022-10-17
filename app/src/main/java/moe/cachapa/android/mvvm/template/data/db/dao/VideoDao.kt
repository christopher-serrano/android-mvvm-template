package moe.cachapa.android.mvvm.template.data.db.dao

import androidx.room.*
import moe.cachapa.android.mvvm.template.data.db.entity.VideoEntity

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: VideoEntity?): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: VideoEntity?)

    @Transaction
    suspend fun upsert(entity: VideoEntity?) {
        val id: Long = insert(entity)
        if (id == -1L)
            update(entity)
    }

    @Query("SELECT * FROM video_detail WHERE id = :id")
    suspend fun fetch(id: Int): VideoEntity?

    @Query("SELECT * FROM video_detail")
    suspend fun fetchAll(): List<VideoEntity>?

    @Query("DELETE FROM video_detail WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM video_detail")
    suspend fun delete()

    @Transaction
    suspend fun purge() {
        val list = fetchAll()
        if (!list.isNullOrEmpty())
            delete()
    }
}