package br.edu.ifpb.example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpb.example.R
import br.edu.ifpb.example.databinding.ItemViewBinding

class NameAdapter(
    private val data: List<String>,
    private val itemClickListener: ItemClickListener,
) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(
        view: View,
        onClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val viewBinding = ItemViewBinding.bind(view)
        private var name: String? = null

        init {
            viewBinding.root.setOnClickListener {
                name?.let {
                    onClickListener.onClick(it)
                }
            }
        }

        fun bind(name: String) {
            this.name = name
            viewBinding.name.text = name
        }
    }

    interface ItemClickListener {
        fun onClick(name: String)
    }
}
