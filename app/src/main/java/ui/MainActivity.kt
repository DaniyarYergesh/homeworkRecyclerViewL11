package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_recyclerview.Add1
import com.example.homework_recyclerview.Currency
import com.example.homework_recyclerview.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFun()
    }

    private fun setupFun() {
        val currencyList = listOf(
            Currency("1 500 000", "Тенге, Казахстан ", R.drawable.image_1),
            Currency("23450", "Доллары, США ", R.drawable.image_1_2),
            Currency("23450", "Лира, Турция", R.drawable.image_1_3),
            Currency("23450", "Евро, EC", R.drawable.image_1_4),
            Currency("23450", "Доллары, США", R.drawable.image_1_5),
            Currency("23450", "Доллары, США", R.drawable.image_1_2),
            Currency("23450", "Доллары, США", R.drawable.image_1_2),
            Currency("23450", "Лира, Турция", R.drawable.image_1_3),
            Currency("23450", "Евро, EC", R.drawable.image_1_4),
            Add1("Добавить", R.drawable.path837)
        )

        val myLambda: () -> Unit =
            {
                val random: Int = Random.nextInt(currencyList.size)
                adapter?.addNewItem(currencyList[random])
                scrollBottom()
            }

        adapter = Adapter(myLambda)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        myRecyclerView.adapter = adapter
        myRecyclerView.layoutManager = layoutManager

        adapter?.setItems(currencyList)


    }

    fun scrollBottom(){
        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int = LinearSmoothScroller.SNAP_TO_START
        }
        smoothScroller.targetPosition = adapter?.itemCount ?: 0
        layoutManager?.startSmoothScroll(smoothScroller) // плавная прокрутка
    }
}