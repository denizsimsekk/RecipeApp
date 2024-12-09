package com.example.foodrecipes.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.foodrecipes.data.model.AnalyzedInstruction
import com.example.foodrecipes.data.model.ExtendedIngredient
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class TypeConvertor {

    @TypeConverter
    fun fromAnalyzedInstructionList(instructions: List<AnalyzedInstruction>?): String {
        return if (instructions == null) "" else Json.encodeToString(instructions)
    }

    @TypeConverter
    fun toAnalyzedInstructionList(data: String): List<AnalyzedInstruction> {
        return if (data.isEmpty()) emptyList() else Json.decodeFromString(data)
    }

    @TypeConverter
    fun fromExtendIngredientsList(instructions: List<ExtendedIngredient>?): String {
        return if (instructions == null) "" else Json.encodeToString(instructions)
    }

    @TypeConverter
    fun toExtendIngredientsList(data: String): List<ExtendedIngredient> {
        return if (data.isEmpty()) emptyList() else Json.decodeFromString(data)
    }

    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return if (value != null) {
            return if (value.isEmpty()) emptyList() else Json.decodeFromString(value)
        } else listOf()
    }
}