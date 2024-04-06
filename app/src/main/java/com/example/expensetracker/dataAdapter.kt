import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.DataModel
import com.example.expensetracker.R


class dataAdapter(val context: Context, val dataList: ArrayList<DataModel>) : RecyclerView.Adapter<dataAdapter.ViewHolder>() {

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
        holder.header.setText(dataList.get(position).header)
        holder.price.setText(dataList.get(position).price)
        holder.month.setText(dataList.get(position).month)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun updateData(newData: List<DataModel>)
    {
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}