package com.example.pizzarestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList:List<ItemsViewModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var itemClickListener: ((Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]


        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)


        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.title_menu
        holder.textViewNIm.text = ItemsViewModel.description_menu
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(position)
        }
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        //        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.tv_title_menu)
        val textViewNIm: TextView = itemView.findViewById(R.id.tv_description_menu)
    }
    fun setOnItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }
}
