package com.maasbodev.rickandmorty.data.local

import androidx.room.TypeConverter
import com.maasbodev.rickandmorty.data.remote.model.OriginLocationObject

class Converters {
    @TypeConverter
    fun fromOriginLocationObject(originLocationObject: OriginLocationObject?): String {
        return if (originLocationObject == null) {
            " ,  "
        } else {
            originLocationObject.name + ", " + originLocationObject.url
        }
    }

    @TypeConverter
    fun stringToOriginLocationObject(concatenatedValue: String?): OriginLocationObject {
        val pff = concatenatedValue?.split(", ")
        return if (pff != null) {
            OriginLocationObject(pff[0], pff[1])
        } else {
            OriginLocationObject("", "")
        }
    }

    @TypeConverter
    fun restoreList(listOfString: String): List<String> {
        return listOfString.split(", ")
    }

    @TypeConverter
    fun saveList(listOfString: List<String>): String {
        return listOfString.joinToString(", ")
    }
}
