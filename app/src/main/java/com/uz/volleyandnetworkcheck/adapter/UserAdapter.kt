package com.uz.volleyandnetworkcheck.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uz.volleyandnetworkcheck.ShowActivity
import com.uz.volleyandnetworkcheck.databinding.ItemUserBinding
import com.uz.volleyandnetworkcheck.model.User

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.binding.textViewLogin.text = user.login
        holder.binding.textViewUserType.text = user.userType

        Glide.with(holder.itemView.context)
            .load(user.avatarUrl)
            .into(holder.binding.imageViewAvatar)

        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, ShowActivity::class.java)
            intent.putExtra("html", user.profileUrl)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = users.size
}
