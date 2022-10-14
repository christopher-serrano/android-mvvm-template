package moe.cachapa.android.mvvm.template.utils.converters

import androidx.room.TypeConverter
import moe.cachapa.android.mvvm.template.data.model.*
import moe.cachapa.android.mvvm.template.utils.parseArray
import moe.cachapa.android.mvvm.template.utils.toJsonString
import moe.cachapa.android.mvvm.template.utils.typeToken

object BaseConverter {

    @TypeConverter
    @JvmStatic
    fun toIntList(input: String?): List<Int>? {
        return input?.let {
            parseArray(it, typeToken<Map<String, List<Int>>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromIntList(input: List<Int>?): String? {
        return input?.toJsonString()
    }

    @TypeConverter
    @JvmStatic
    fun toBelongsToCollection(input: String?): BelongsToCollection? {
        return input?.let {
            parseArray(it, typeToken<Map<String, BelongsToCollection>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromBelongsToCollection(input: BelongsToCollection?): String? {
        return input?.toJsonString()
    }

    @TypeConverter
    @JvmStatic
    fun toGenreList(input: String?): List<Genre>? {
        return input?.let {
            parseArray(it, typeToken<Map<String, List<Genre>>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromGenreList(input: List<Genre>?): String? {
        return input?.toJsonString()
    }

    @TypeConverter
    @JvmStatic
    fun toProductionCompanyList(input: String?): List<ProductionCompany>? {
        return input?.let {
            parseArray(it, typeToken<Map<String, List<ProductionCompany>>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromProductionCompanyList(input: List<ProductionCompany>?): String? {
        return input?.toJsonString()
    }

    @TypeConverter
    @JvmStatic
    fun toSpokenLanguageList(input: String?): List<SpokenLanguage>? {
        return input?.let {
            parseArray(it, typeToken<Map<String, List<SpokenLanguage>>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromSpokenLanguageList(input: List<SpokenLanguage>?): String? {
        return input?.toJsonString()
    }

    @TypeConverter
    @JvmStatic
    fun toProductionCountryList(input: String?): List<ProductionCountry>? {
        return input?.let {
            parseArray(it, typeToken<Map<String, List<ProductionCountry>>>().type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromProductionCountryList(input: List<ProductionCountry>?): String? {
        return input?.toJsonString()
    }

}