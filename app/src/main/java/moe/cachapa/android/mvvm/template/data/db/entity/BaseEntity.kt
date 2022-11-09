package moe.cachapa.android.mvvm.template.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

abstract class BaseEntity {
    @ColumnInfo(name = "table_id")
    @PrimaryKey(autoGenerate = true)
    var tableId: Long = 0

    @ColumnInfo(name = "region")
    var region: String? = ""
}
