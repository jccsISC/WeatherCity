package com.jccsisc.weathermodule.fragments.menu.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jccsisc.weathermodule.databinding.WItemCityBinding
import com.jccsisc.weathermodule.fragments.menu.model.CityModel

class WMenuAdapter: ListAdapter<CityModel, WMenuAdapter.CityViewHolder>(DiffCallback) {

    lateinit var onItemClickListener: (CityModel) -> Unit

    companion object DiffCallback: DiffUtil.ItemCallback<CityModel>() {

        override fun areItemsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WMenuAdapter.CityViewHolder {
        val binding = WItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WMenuAdapter.CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

    inner class CityViewHolder(private val binding: WItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(citiItem: CityModel) = with(binding) {

            Glide.with(root.context)
                .load(citiItem.image)
                .centerCrop()
                .into(imgCity)

            txtNameCity.text = citiItem.name

            root.setOnClickListener {
                //si está inicializada la variable landa mandamos llamar el onItemClickListener
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(citiItem) //llamamos nuestro landa, donde lo usemos le asignamos la accion
                } else {
                    Log.e(TAG, "onItemClickListener no inicializado")
                }
            }
        }
    }
}