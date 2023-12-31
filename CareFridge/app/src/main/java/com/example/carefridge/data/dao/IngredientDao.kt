package com.example.carefridge.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.carefridge.data.entities.Ingredient

@Dao
interface IngredientDao {
    @Insert
    fun insert(ingredient: Ingredient)

    @Update
    fun update(ingredient: Ingredient)

    @Delete
    fun delete(ingredient: Ingredient)

    @Query("DELETE FROM IngredientTable WHERE id=:ingredientId")
    fun deleteIngredientById(ingredientId: Int)

    @Query("SELECT * FROM IngredientTable")
    fun getIngredients(): List<Ingredient>

    @Query("SELECT * FROM IngredientTable")
    fun getIngredientsLiveData(): LiveData<List<Ingredient>>

    // 사용자가 선호하는 재료 목록을 가져옴
    @Query("SELECT * FROM IngredientTable WHERE isPrefer = :isPrefer")
    fun getUserPreferIngredients(isPrefer: Boolean): List<Ingredient>
}
