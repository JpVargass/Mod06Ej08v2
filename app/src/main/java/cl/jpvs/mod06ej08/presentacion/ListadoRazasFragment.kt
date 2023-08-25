package cl.jpvs.mod06ej08.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.jpvs.mod06ej08.R
import cl.jpvs.mod06ej08.data.local.RazaEntity
import cl.jpvs.mod06ej08.databinding.FragmentListadoRazasBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListadoRazasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListadoRazasFragment : Fragment() {

 lateinit var binding: FragmentListadoRazasBinding
    private val listItemRaza = mutableListOf<RazaEntity>()

 private val razaViewModel : RazaViewModel by activityViewModels()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoRazasBinding.inflate(layoutInflater, container,false)
        initAdapter()
        razaViewModel.getAllRazas()
        return binding.root
    }

    private fun initAdapter() {
       val adapter = AdapterRaza()
        binding.rcRazas.adapter = adapter
        razaViewModel.razaLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

    }

}
