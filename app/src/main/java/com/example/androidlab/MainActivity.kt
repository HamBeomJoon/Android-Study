import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlab.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.DogData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter //adapter객체 먼저 선언해주기!

    val mDatas = mutableListOf<DogData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializelist()
        initDogRecyclerView()

    }

    fun initDogRecyclerView() {
        val adapter = RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(mDatas) {
            add(DogData("", "dog1", 20, "M"))
            add(DogData("", "dog2", 20, "M"))
            add(DogData("", "dog3", 20, "M"))
            add(DogData("", "dog4", 20, "M"))
            add(DogData("", "dog5", 20, "M"))
            add(DogData("", "dog2", 20, "M"))
            add(DogData("", "dog6", 20, "M"))
            add(DogData("", "dog7", 20, "M"))
            add(DogData("", "dog8", 20, "M"))
            add(DogData("", "dog9", 20, "M"))
            add(DogData("", "dog10", 20, "M"))
            add(DogData("", "dog11", 20, "M"))
            add(DogData("", "dog12", 20, "M"))
        }
    }
}