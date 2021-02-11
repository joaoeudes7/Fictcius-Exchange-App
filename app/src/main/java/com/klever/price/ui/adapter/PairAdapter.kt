package com.klever.price.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdeve.mesanews.utils.asyncListDifferOf
import com.klever.price.databinding.ItemCoinBinding
import com.klever.price.domain.entities.PairCoinModel

class PairAdapter(
    private val onSelectPair: (PairCoinModel) -> Unit,
) : RecyclerView.Adapter<PairAdapter.PairViewHolder>() {

    // Alternativa de comparação, como falta id :/
    private val values = asyncListDifferOf<PairCoinModel> { new, old -> new.code == old.code }

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

    fun submitData(items: List<PairCoinModel>) {
        values.submitList(items)
    }

    inner class PairViewHolder(
        private val binding: ItemCoinBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pair: PairCoinModel) = binding.run {
            txtCode.text = pair.code
            price.text = "%.2f".format(pair.price)

            if (pair.percentDiff > 0) {
                showPriceUpStyle()
            } else {
                showPriceDownStyle()
            }
        }

        private fun showPriceUpStyle() {

        }

        private fun showPriceDownStyle() {

        }
    }
}