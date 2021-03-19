package com.alexis.morison.tragosapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexis.morison.tragosapp.base.BaseViewHolder
import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.databinding.DrinksRowBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MainAdapter(
    private val context: Context,
    private val drinkList: List<Drink>,
    private val itemClickListener: OnDrinkClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnDrinkClickListener {

        fun onDrinkClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val itemBinding = DrinksRowBinding.inflate(LayoutInflater.from(context), parent, false)

        val holder = MainViewHolder(itemBinding)

        //return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.drinks_row, parent, false))

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when (holder) {
            is MainViewHolder -> holder.bind(drinkList[position], position)
        }
    }

    override fun getItemCount(): Int = drinkList.size


    inner class MainViewHolder(private val binding: DrinksRowBinding) :
        BaseViewHolder<Drink>(binding.root) {

        override fun bind(item: Drink, position: Int) = with(binding) {

            Picasso.get()
                .load(item.image)
                .into(imgDrink, object : Callback {

                    override fun onSuccess() {
                        //view.main_card_progress.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        //view.main_card_progress.visibility = View.GONE
                    }
                })

            textTitle.text = item.name
            textDescription.text = item.description

            binding.root.setOnClickListener {

                itemClickListener.onDrinkClick(item)
            }
        }
    }
}