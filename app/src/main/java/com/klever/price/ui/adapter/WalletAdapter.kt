package com.klever.price.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdeve.mesanews.utils.asyncListDifferOf
import com.klever.price.databinding.ItemCoinBinding
import com.klever.price.domain.entities.WalletCoinModel

class WalletAdapter : RecyclerView.Adapter<WalletAdapter.PairViewHolder>() {

    private val values = asyncListDifferOf<WalletCoinModel> { new, old -> new.coinCode == old.coinCode }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PairViewHolder {
        val context = parent.context
        val view = ItemCoinBinding.inflate(LayoutInflater.from(context), parent, false)

        return PairViewHolder(view)
    }

    override fun onBindViewHolder(holder: PairViewHolder, position: Int) {
        holder.bind(values.currentList[position])
    }

    override fun getItemCount(): Int {
        return values.currentList.size
    }

    fun submitData(items: List<WalletCoinModel>) {
        values.submitList(items)
    }

    inner class PairViewHolder(
        private val binding: ItemCoinBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(wallet: WalletCoinModel) = binding.run {
            txtCode.text = wallet.coinCode
            price.text = wallet.equity.toString()
        }
    }
}