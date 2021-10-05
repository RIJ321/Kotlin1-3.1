package com.example.kotlin1_31.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1_31.R
import com.example.kotlin1_31.databinding.RvItemImgBinding

class MyAdapter(
    private var list: ArrayList<Int>,
    private var bgListener: BGListener?
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var binding: RvItemImgBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = RvItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(itemView: RvItemImgBinding) : RecyclerView.ViewHolder(itemView.root) {

        fun onBind(image: Int) {
            binding.rvImg.setImageResource(image)

            binding.rvImg.setOnClickListener {
                if (binding.rvImg.colorFilter == null) {
                    binding.rvImg.setColorFilter(R.color.black)
                    bgListener?.changeBG(image)
                } else {
                    binding.rvImg.colorFilter = null
                    bgListener?.remove(image)
                }
            }
        }
    }

}

interface BGListener {
    fun changeBG(image: Int)
    fun remove (image: Int)
}