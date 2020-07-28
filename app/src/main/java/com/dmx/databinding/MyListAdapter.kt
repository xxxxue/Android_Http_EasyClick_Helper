package com.dmx.databinding

import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.dmx.databinding.databinding.StudentItemBinding
import com.dmx.databinding.model.Student
import com.hjq.toast.ToastUtils

class MyListAdapter(list: MutableList<Student>) :
    BaseQuickAdapter<Student, BaseViewHolder>(R.layout.student_item, list) {

    override fun convert(holder: BaseViewHolder, item: Student) {

        val binding = BaseDataBindingHolder<StudentItemBinding>(holder.itemView).dataBinding

        if (binding != null) {
            binding.vm = item
            binding.executePendingBindings()
        }

    }


}