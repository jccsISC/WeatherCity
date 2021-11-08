package com.jccsisc.weathermodule.fragments.menu.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.databinding.WItemCityBinding
import com.jccsisc.weathermodule.fragments.menu.model.WMenuCityModel

class WMenuAdapter: ListAdapter<WMenuCityModel, WMenuAdapter.CityViewHolder>(DiffCallback) {

    lateinit var onItemClickListener: (WMenuCityModel) -> Unit

    companion object DiffCallback: DiffUtil.ItemCallback<WMenuCityModel>() {

        override fun areItemsTheSame(oldItem: WMenuCityModel, newItem: WMenuCityModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WMenuCityModel, newItem: WMenuCityModel): Boolean {
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
        fun bind(citiItem: WMenuCityModel) = with(binding) {

            Glide.with(root.context)
                .load(citiItem.image)
                .centerCrop()
                .into(imgCity)

            txtNameCity.text = citiItem.name
            txtCountry.text = root.context.getString(R.string.country, citiItem.country)
            txtLocation.text = root.context.getString(R.string.location, citiItem.coord.lat, citiItem.coord.lon)

            root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(citiItem) //llamamos nuestro landa, donde lo usemos le asignamos la accion
                } else {
                    Log.e(TAG, "onItemClickListener no inicializado")
                }
            }
        }
    }
}