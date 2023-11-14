package recycleview.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bird_app.R

class birdadapter  (private val birdlist:ArrayList<bird>): RecyclerView.Adapter<birdadapter.BirdViewHolder> () {


var onItemClick : ((bird) -> Unit)? = null
    class BirdViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        var itemimg: ImageView = itemView.findViewById(R.id.itemimg)
        var itemtxt1: TextView = itemView.findViewById(R.id.itemtxt1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val v = LayoutInflater.from(  parent.context).inflate(R.layout.card_list, parent, false)
        return BirdViewHolder(v)

    }

    override fun getItemCount(): Int {
        return birdlist.size
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = birdlist[position]

        holder.itemimg.setImageResource(bird.image)
        holder.itemtxt1.text = bird.name

        holder.itemView.setOnClickListener{

            onItemClick?.invoke(bird)
        }
    }
}