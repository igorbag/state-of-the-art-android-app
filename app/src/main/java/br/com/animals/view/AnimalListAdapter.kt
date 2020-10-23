package br.com.animals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import br.com.animals.R
import br.com.animals.databinding.ItemAnimalBinding
import br.com.animals.model.Animal
import br.com.animals.util.getProgressDrawable
import br.com.animals.util.loadImage
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalListAdapter(private val animalList: ArrayList<Animal>): RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>(),
    AnimalClickListener {

    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalList.clear()
        animalList.addAll(newAnimalList)

        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val animal = animalList.find { it.name == v.tag }

        animal?.let {
            val action = ListFragmentDirections.actionDetail(it)
            Navigation.findNavController(v).navigate(action)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: ItemAnimalBinding = DataBindingUtil.inflate(inflater, R.layout.item_animal, parent, false)

        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.view.animal = animalList[position]
        holder.view.listener = this

        /*
        holder.view.animalLayout.setOnClickListener {
            val action = ListFragmentDirections.actionDetail(holder.view.animal)
            Navigation.findNavController(holder.view.root).navigate(action)
        }
        */
    }

    class AnimalViewHolder(var view: ItemAnimalBinding): RecyclerView.ViewHolder(view.root)
}