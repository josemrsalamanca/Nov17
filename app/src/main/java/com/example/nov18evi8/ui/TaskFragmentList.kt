package com.example.nov18evi8.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nov18evi8.Modelo.Task
import com.example.nov18evi8.databinding.FragmentTaskListBinding
import com.example.nov18evi8.presentacion.TaskViewModel

// dentro de la carpeta creada se va a hacer un fragment que hereda de fragment para mostrar el listado de tareas
class TaskFragmentList : Fragment(){

    //es ncesario iniciar el binding, pero no hay xml del TaskFragmentList
    // creamos un xml FragmentTaskList

    //parece que esto no va ahora
    //private lateinit var binding:FragmentTaskListBinding

    // hay que llamar al binding
    private lateinit var binding: FragmentTaskListBinding
    //TODO DE NUEVO

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // reclama el activity porque puede ser nulo, se hace lo siguiente
    private suspend fun suscribeViewModel() {
        //Ahora se hace lo del task
        activity?.let { notNullActivity ->
            // el problema con el taskviewmodel es que para llamarlo necesita un constructor ()
            val model = TaskViewModel(application = notNullActivity.application)
            // el getLiveData se hace por el encapsulamiento, para no pedir directamentre el listadoDeTareas
            // cuando estamos en un activity le pasamos el this, pero como es un fragment viewlifecucleowner
            model.getLiveData().observe(viewLifecycleOwner, { tasks ->
                // el <user, aca es Task>
                // el getUsers() vuela
                // es codigo redundante Observer<List<Task>>
                // ahora hay que cargar los tasks
                renderUI(tasks)
            })
            model.obtenerTareas()
        }

    }
// para tener un layout copio el del ejercicio anterior
    private fun renderUI(tasks: List<Task>?) {
//aca recibo la lista de usuario
        // llamo al size, para saber cuantas tareas hay
        // reclama el punto, es por ?
        Toast.makeText(activity, "El total de tasks es: ${tasks?.size}",Toast.LENGTH_LONG).show()
    }

// CREO QUE ENCONTRE EL PROBLEMA
}