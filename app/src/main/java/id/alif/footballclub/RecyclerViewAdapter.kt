package id.alif.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class RecyclerViewAdapter (private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(item_list().createView(AnkoContext.create(context,parent)))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(item_list.nameClub)
        private val image = view.findViewById<ImageView>(item_list.imageClub)

        fun bindItem(items: Item,listener: (Item) -> Unit) {
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
            itemView.setOnClickListener {
                listener(items)


            }
        }
    }
}