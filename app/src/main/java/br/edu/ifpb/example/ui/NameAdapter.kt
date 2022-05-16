package br.edu.ifpb.example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpb.example.R
import br.edu.ifpb.example.data.Student
import br.edu.ifpb.example.databinding.ItemViewBinding

class NameAdapter(
    private val data: Array<Student>,
    private val itemClickListener: ItemClickListener,
) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        view: View,
        onClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val viewBinding = ItemViewBinding.bind(view)
        private var student: Student? = null

        init {
            viewBinding.root.setOnClickListener {
                student?.let { student ->
                    onClickListener.onClick(student)
                }
            }
        }

        fun bind(student: Student) {
            this.student = student
            viewBinding.name.text = student.name
            viewBinding.email.text = student.email
        }
    }

    interface ItemClickListener {
        fun onClick(student: Student)
    }
}
