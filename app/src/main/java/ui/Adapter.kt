package ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_recyclerview.*

class Adapter(private val clickListener: () -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item -> CurrencyViewHolder(inflater, parent)
            R.layout.item2 -> AddButtonViewHolder(inflater, parent, clickListener)
            else -> CurrencyViewHolder(inflater, parent)
        }

    }

    override fun getItemViewType(position: Int): Int =
        when (data[position]) {
            is Currency -> R.layout.item
            is Add1 -> R.layout.item2
            else -> R.layout.item
        }


    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CurrencyViewHolder -> holder.bind(data[position] as Currency)
            is AddButtonViewHolder -> holder.bind(data[position] as Add1)
        }
    }

    fun setItems(list: List<Any>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun addNewItem(newItem: Any) {
        data.add(data.size - 1, newItem as Currency)
        notifyDataSetChanged()
    }

}