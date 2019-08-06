package com.chanop.base.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanop.base.R

class BaseAdapter(val context: Context , itemList: ArrayList<ListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val itemList = itemList
    
    override fun getItemCount(): Int {
        return itemList.size
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent, false)
        return   BaseViewHolder(view,this)
    }
    
    class BaseViewHolder(itemView: View, private val adapter: BaseAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        
        init {
        }
        
        override fun onClick(v: View?) {
        }
    }
    
    data class ListItem(val item: Any)
}