package com.example.nov18evi8.Modelo

import androidx.lifecycle.LiveData
import androidx.room.*

// copy paste diapo 14
// importamos todas las clases del framework de ROOM
@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)
    @Insert
    suspend fun insertMultipleTask(list: List<Task>)
    @Update
    suspend fun updateTask(task: Task)
    @Delete
    suspend fun deleteOneTask(task: Task)
    @Query("SELECT * FROM task_table ORDER BY idTask ASC")
        fun getAllTask(): LiveData<List<Task>>
}


// esto es lo mismo de SQL
// falta la bd