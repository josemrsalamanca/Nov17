package com.example.nov18evi8.Modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// coy/paste diapo 16
// importar
// esta clase hace la magia, crea la bd
@Database(entities = [Task::class], version = 1, exportSchema
= false)
abstract class TaskDataBase : RoomDatabase(){
    abstract fun getTaskDao(): TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDataBase? = null
        fun getDatabase(context: Context): TaskDataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

// TASK ES LA TABLA
// TASK DAO PARA OPERAR EN LA TABLA, AGREGAR, MODIFICAR, ELIMINAR, ETC
// TASK DATA BASE, ES LA BD