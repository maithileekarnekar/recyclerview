package com.example.recyclerview

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.random.Random

class CitiesAdapter (
    private val cities : ArrayList<String>
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    var countofOnCreate = 0;

    inner class CityViewHolder(val txtCity: TextView) : ViewHolder(txtCity) {
        init {
            txtCity.setOnClickListener{
                Toast.makeText(
                    it.context,
                    cities[adapterPosition],
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }



    override fun getItemCount() = cities.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val random = Random(System.currentTimeMillis())

        val txtCity = TextView(parent.context)
        txtCity.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        txtCity.textSize = 30F
        txtCity.setTextColor(Color.BLACK)
        /*txtCity.setBackgroundColor(
            Color.rgb(
                Math.abs(random.nextInt() % 255),
                Math.abs(random.nextInt() % 255),
                Math.abs(random.nextInt() % 255)
            )
        )*/

        return CityViewHolder(txtCity)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.txtCity.text = cities[position]
    }



}