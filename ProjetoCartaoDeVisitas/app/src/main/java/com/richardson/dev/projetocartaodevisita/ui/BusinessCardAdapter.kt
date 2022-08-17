package com.richardson.dev.projetocartaodevisita.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.richardson.dev.projetocartaodevisita.data.BusinessCard
import com.richardson.dev.projetocartaodevisita.databinding.BusinessCardBinding

class BusinessCardAdapter:ListAdapter<BusinessCard,BusinessCardAdapter.ViewHolder>(DiffCallback()){

    var listenerShare:(View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  = BusinessCardBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }




    inner class ViewHolder( private val biding:BusinessCardBinding):RecyclerView.ViewHolder
        (biding.root){
            fun bind(item:BusinessCard){
                biding.txtBusinessCard.text = item.name
                biding.txtEmail.text = item.email
                biding.txtContact.text = item.contact
                biding.txtCompany.text = item.company
                biding.mcCardContent.setOnClickListener { listenerShare(it) }

            }
        }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id

}
