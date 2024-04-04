import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.R
import com.example.expensetracker.dataModel

class dataAdapter(private val context: Context, private val dataList: ArrayList<dataModel>) : RecyclerView.Adapter<dataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header: TextView = itemView.findViewById(R.id.header)
        val price: TextView = itemView.findViewById(R.id.price)
        val month: TextView = itemView.findViewById(R.id.month)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.header.text = currentItem.header
        holder.price.text = currentItem.price.toString()
        holder.month.text = currentItem.month.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}