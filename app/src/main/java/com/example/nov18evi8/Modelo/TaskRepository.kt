package com.example.nov18evi8.Modelo

import androidx.lifecycle.LiveData

interface TaskRepository {
    //Se crean las f(x)
    // del repositorio creado se crean las funciones
    //Ahora se necesita una clase concreta que implemente esta interfaz, esa clase es RoomTaskRepository
    suspend fun getAllTasks(): LiveData<List<Task>>
    suspend fun newTask(new: Task)
    suspend fun deleteAll()
}