package com.example.lab_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AnimalAdapter(
    private val animals: List<Animal>,
    private val navController: NavController
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val latinTextView: TextView = itemView.findViewById(R.id.latinTextView)
        val animalLayout: LinearLayout = itemView.findViewById(R.id.animalLayout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]

        Glide.with(holder.imageView.context).load(animal.url).into(holder.imageView)

        holder.nameTextView.text = animal.name
        holder.latinTextView.text = animal.latin

        holder.animalLayout.setOnClickListener {
            navController.navigate(
                MainFragmentDirections.actionMainFragmentToDetailsFragment(animal)
            )
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }
}
