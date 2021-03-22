package com.alexis.morison.tragosapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexis.morison.tragosapp.base.BaseViewHolder
import com.alexis.morison.tragosapp.data.model.Cocktail
import com.alexis.morison.tragosapp.databinding.DrinksRowBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MainAdapter(
    private val context: Context,
    private val cocktailList: List<Cocktail>,
    private val itemClickListener: OnDrinkClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnDrinkClickListener {

        fun onDrinkClick(cocktail: Cocktail, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val itemBinding = DrinksRowBinding.inflate(LayoutInflater.from(context), parent, false)

        val holder = MainViewHolder(itemBinding)

        //return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.drinks_row, parent, false))

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when (holder) {
            is MainViewHolder -> holder.bind(cocktailList[position], position)
        }
    }

    override fun getItemCount(): Int = cocktailList.size


    inner class MainViewHolder(private val binding: DrinksRowBinding) :
        BaseViewHolder<Cocktail>(binding.root) {

        override fun bind(item: Cocktail, position: Int) = with(binding) {

            Picasso.get()
                .load(item.image)
                .into(imgDrink, object : Callback {

                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        progressBar.visibility = View.GONE
                    }
                })

            textTitle.text = item.name
            textDescription.text = item.description

            binding.root.setOnClickListener {

                itemClickListener.onDrinkClick(item, position)
            }
        }
    }
}