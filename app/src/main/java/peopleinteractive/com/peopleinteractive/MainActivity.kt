package peopleinteractive.com.peopleinteractive

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.aztechz.projectbinaryveda.ViewModel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this@MainActivity)


        val model = ViewModelProviders.of(this).get<DataViewModel>(DataViewModel::class.java)

        model.getData().observe(this, Observer { p ->

            val resultList = p?.results

            Log.d("Size of ", resultList?.size.toString())

                recycler.adapter =
                        ProductAdapter(
                            resultList!!,
                            context = applicationContext
                        )
            (recycler.adapter as ProductAdapter).notifyDataSetChanged()


        })

    }
}
