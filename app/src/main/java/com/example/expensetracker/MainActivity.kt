import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.DBOperations
import com.example.expensetracker.databinding.ActivityMainBinding
import com.example.expensetracker.DataModel
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recView: RecyclerView
    private lateinit var adapter: dataAdapter
    private lateinit var dataList: ArrayList<DataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recView = binding.recView
        dataList = ArrayList()
        adapter = dataAdapter(this,dataList)

        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = adapter

        val db = DBOperations(this)
        db.insertData(20, "Merhaba", 3)

        // Veritabanından verileri al ve RecyclerView'de göster
        dataList.addAll(db.readData())
        adapter.notifyDataSetChanged()
    }
}