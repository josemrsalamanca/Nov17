package com.example.nov18evi8.Modelo

import androidx.lifecycle.LiveData
import java.util.function.ToDoubleBiFunction

//aca se implementa la interfaz
//El room necesita objetos que se hacen dentro del ()
// Lo que esta entre () es una delegación de la creacion del objeto a otra clase (inyeccion de dependencia)
class RoomTaskRepository(val taskDao: TaskDao) : TaskRepository {
    override suspend fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAllTask()
    }
    override suspend fun newTask(new: Task){
        return taskDao.insertTask(new)
        // dice que el insertask no devuelve nada, entonces tampoco se le puede pedir que devuelva algo
        // eso se ve en el tasrepository

        // pequeño gran detalle que se le olvida, hay que hacerla suspend, esto porque se van a ejeutar en un hilo
        // secundario, lo que introduce a lo de las corrutinas
    }

    override suspend fun deleteAll() {
        TODO("queda pendiente")
    }
}