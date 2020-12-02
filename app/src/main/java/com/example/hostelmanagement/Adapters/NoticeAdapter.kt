package com.example.hostelmanagement.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hostelmanagement.database.StudentNotice
import com.example.hostelmanagement.databinding.NoticeItemBinding

class NoticeAdapter : ListAdapter<StudentNotice, NoticeAdapter.NoticeViewHolder>(diffCallback) {
    class NoticeViewHolder(private val binding: NoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(studentNotice: StudentNotice) {
            binding.noticeImageView.setImageBitmap(studentNotice.notice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(NoticeItemBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val currentNotice = getItem(position)
        holder.bind(currentNotice)
    }

    companion object diffCallback : DiffUtil.ItemCallback<StudentNotice>() {
        override fun areItemsTheSame(oldItem: StudentNotice, newItem: StudentNotice): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: StudentNotice, newItem: StudentNotice): Boolean {
            return oldItem._id == newItem._id
        }

    }
}
