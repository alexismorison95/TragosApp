package com.alexis.morison.tragosapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    @SerializedName("idDrink")
    val id: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strInstructions")
    val description: String = "",
    @SerializedName("strAlcoholic")
    val hasAlcohol: String = "Non alcoholic",
    @SerializedName("strIngredient1")
    val ingredient1: String?,
    @SerializedName("strIngredient2")
    val ingredient2: String?,
    @SerializedName("strIngredient3")
    val ingredient3: String?,
    @SerializedName("strIngredient4")
    val ingredient4: String?,
    @SerializedName("strIngredient5")
    val ingredient5: String?,
    @SerializedName("strIngredient6")
    val ingredient6: String?,
) : Parcelable


data class CocktailList(
    @SerializedName("drinks")
    val cocktailList: List<Cocktail>
)

@Entity
data class DrinkEntity(
    @PrimaryKey
    val drinkId: String,
    @ColumnInfo(name = "drinkName")
    val name: String = "",
    @ColumnInfo(name = "drinkThumb")
    val image: String = "",
    @ColumnInfo(name = "instructions")
    val description: String = "",
    @ColumnInfo(name = "isAlcoholic")
    val hasAlcohol: String = "Non alcoholic",
    @ColumnInfo(name = "ingredient1")
    val ingredient1: String?,
    @ColumnInfo(name = "ingredient2")
    val ingredient2: String?,
    @ColumnInfo(name = "ingredient3")
    val ingredient3: String?,
    @ColumnInfo(name = "ingredient4")
    val ingredient4: String?,
    @ColumnInfo(name = "ingredient5")
    val ingredient5: String?,
    @ColumnInfo(name = "ingredient6")
    val ingredient6: String?,
)