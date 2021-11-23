package com.example.nov18evi8.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nov18evi8.Modelo.RoomTaskRepository
import com.example.nov18evi8.Modelo.Task
import com.example.nov18evi8.Modelo.TaskDataBase
import com.example.nov18evi8.Modelo.TaskRepository
import kotlinx.coroutines.launch

//copy/paste leccion 7 diapo 31
class TaskViewModel(application: Application) : AndroidViewModel(application) {

    //copy/paste El TaskRepository hay que crear una interfaz en el modelo, en la siguiente linea se crea
    private val repository: TaskRepository//aca abajo se acuerda que le falta el list
    private val listadoDeTareas = MutableLiveData<List<Task>>()
    private val liveData: LiveData<List<Task>> = listadoDeTareas

// ahora se genera aca arriba el problema, se soluciona con un mutable
    // Aca hay que crear el cuerpo del constructor con init

    init {
        // aca copy/paste diapo, se dice que no es muy bueno, por temas de responsabilidades de objetos
        // aca la clae TaskDataBase, llama al get, le pasamos el application y luego le pasamos el dao
        val taskDao = TaskDataBase.getDatabase(application).getTaskDao()

        // aca se implementa el repositorio y se le paso el ()
        repository = RoomTaskRepository(taskDao)

        // por error anterior, ahora esto no se puede usar por  lo del suspend!!!

        // las 2 lineas anteriores estan relacionadas, la primera hace la lista de tareas de manera encapsulada, la segunda
        // instancia ese listado.

    }

        suspend fun obtenerTareas(){
            // aca reclama porque ahora es suspend, hay que hacer algo
            viewModelScope.launch {
                repository.getAllTasks()
            }
        }
        suspend fun getLiveData() : LiveData<List<Task>>{
            return listadoDeTareas
        }


        // Hay que crear las f(x) para el newtask y el deleteall


        suspend fun newTask(task: Task){
            repository.newTask(task)
        }

        suspend fun deleteAll(){
            repository.deleteAll()
        }

}