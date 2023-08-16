package com.avekado.weatherapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avekado.weatherapp.R
import com.avekado.weatherapp.databinding.WeatherItemBinding
import com.avekado.weatherapp.model.WeatherModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

class WeatherAdapter(private val context : Context, private var list: ArrayList<WeatherModel>):
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding : WeatherItemBinding = WeatherItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(item)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val data = list[position]
        holder.binding.textViewTemperature.text = data.temperature.toString() + "°c"
        holder.binding.textViewWindSpeed.text = data.windSpeed.toString()+" Km/h"
        val input = SimpleDateFormat("yyyy-MM-dd hh:mm")
        val output2 = SimpleDateFormat("yyyy-MM-dd")
        val output = SimpleDateFormat("hh:mm aa")
        try {
            val t : Date = input.parse(data.time)
            holder.binding.textViewTime.text = output.format(t)
            holder.binding.textViewDate.text = output2.format(t)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    }