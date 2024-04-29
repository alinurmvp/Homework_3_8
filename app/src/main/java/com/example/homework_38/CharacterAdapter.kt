package com.example.homework_38


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.homework_38.databinding.ItemCharactersBinding

class CharacterAdapter(private var characterList: ArrayList<CharacterModel>, val onClick: (model: CharacterModel) -> Unit) :
    Adapter<CharacterAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding: ItemCharactersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (characterModel: CharacterModel){
            binding.apply {
                characterModel.apply {
                    tvStatus.text = status
                    tvName.text = name
                    Glide.with(imgPhoto).load(image).into(imgPhoto)

                    itemView.setOnClickListener {
                        onClick.invoke(characterModel)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }
}