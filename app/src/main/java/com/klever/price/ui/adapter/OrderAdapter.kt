package com.klever.price.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdeve.mesanews.utils.asyncListDifferOf
import com.klever.price.databinding.ItemCoinBinding
import com.klever.price.databinding.ItemOrderBinding
import com.klever.price.domain.entities.OrderModel

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private val values = asyncListDifferOf<OrderModel> { new, old -> new.id == old.id }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val context = parent.context
        val view = ItemOrderBinding.inflate(LayoutInflater.from(context), parent, false)

        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(values.currentList[position])
    }

    override fun getItemCount(): Int {
        return values.currentList.size
    }

    fun submitData(items: List<OrderModel>) {
        values.submitList(items)
    }

    inner class OrderViewHolder(
        private val binding: ItemOrderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: OrderModel) = binding.run {
            txtCode.text = order.pair
            price.text = order.price.toString()
        }
    }
}