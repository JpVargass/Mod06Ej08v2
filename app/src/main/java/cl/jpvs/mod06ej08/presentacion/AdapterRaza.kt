package cl.jpvs.mod06ej08.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.mod06ej08.R
import cl.jpvs.mod06ej08.data.local.RazaEntity
import cl.jpvs.mod06ej08.databinding.FragmentListadoRazasBinding
import cl.jpvs.mod06ej08.databinding.ItemRazaBinding

class AdapterRaza :RecyclerView.Adapter<AdapterRaza.ItemRazaViewHolder>() {
lateinit var binding: ItemRazaBinding
private val listItemRaza = mutableListOf<RazaEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRazaViewHolder {
        binding = ItemRazaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemRazaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRaza.size
    }


    override fun onBindViewHolder(holder: ItemRazaViewHolder, position: Int) {
        val raza = listItemRaza[position]
        holder.bind(raza)
    }

    fun  setData(razaEntity: List<RazaEntity>) {
        this.listItemRaza.clear()
        this.listItemRaza.addAll(razaEntity)
        notifyDataSetChanged()
    }

    class ItemRazaViewHolder(val razaVista:ItemRazaBinding) : RecyclerView.ViewHolder(razaVista.root) {
     fun bind(itemRaza : RazaEntity) {
         val bundle = Bundle()
         razaVista.tvRaza.text = itemRaza.raza
         razaVista.cvRaza.setOnClickListener{
             bundle.putString("id",itemRaza.raza)
             // navigation
              Navigation.findNavController(razaVista.root).navigate(R.id.action_listadoRazasFragment_to_fragment_detalle, bundle)

         }
     }
    }
}