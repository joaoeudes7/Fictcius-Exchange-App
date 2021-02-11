package com.klever.price.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdeve.mesanews.utils.asyncListDifferOf
import com.klever.price.databinding.ItemCoinBinding
import com.klever.price.domain.entities.CoinModel

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    private val values = asyncListDifferOf<CoinModel> { new, old -> new.code == old.code }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val context = parent.context
        val view = ItemCoinBinding.inflate(LayoutInflater.from(context), parent, false)

        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(values.currentList[position])
    }

    override fun getItemCount(): Int {
        return values.currentList.size
    }

    fun submitData(items: List<CoinModel>) {
        values.submitList(items)
    }

    inner class CoinViewHolder(
        private val binding: ItemCoinBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: CoinModel) = binding.run {
            binding.price.text = "%.2f".format(coin.value)
            binding.txtCode.text = coin.code
        }
    }
}