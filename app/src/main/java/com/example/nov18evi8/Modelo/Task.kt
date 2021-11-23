package com.example.nov18evi8.Modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

//COPY PASTE DIAPO 13, leccion 6

@Entity(tableName = "task_table")
data class
Task(@PrimaryKey(autoGenerate = true)
     @NonNull val idTask: Int,
     val task:String,
     val creationDate:String,
     val finishDate:String
)

// Ya tenemos creada la tabla, ahora el DAO, ojo interfaz