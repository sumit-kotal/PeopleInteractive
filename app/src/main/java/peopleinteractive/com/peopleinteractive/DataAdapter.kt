package peopleinteractive.com.peopleinteractive

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_item.view.*
import peopleinteractive.com.peopleinteractive.Models.Result
import java.text.SimpleDateFormat
import java.util.*

class ProductAdapter(val items : List<Result>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Inflates the item views
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        Log.d("inside adap","inside")
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_item,
                p0,
                false
            )
        )
    }

    // Binds each product in the ArrayList to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = items[position].name?.first
        holder.name.text = items[position].name?.first
        holder.age.text = items[position].name?.first
        holder.address.text = items[position].name?.first
        holder.career.text = items[position].name?.first


    }

    // Gets the number of products in the list
    override fun getItemCount(): Int {
        return items.size
    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each product to
    val time = view.time
    val name = view.name
    val age = view.age
    val address = view.address
    val career = view.career
    val decline = view.decline
    val accept = view.accept

}

fun dateTime(dateString: String?): String {
    Log.d("235",dateString)

    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    input.timeZone = TimeZone.getTimeZone("UTC")

    val dt = input.parse(dateString)
    Log.d("235",dt.toString())



    val sdfDtTime = SimpleDateFormat("d MMM yyyy hh:mm a")

    val sdfDate = SimpleDateFormat("dd MMM yyyy")
    sdfDate.timeZone = java.util.TimeZone.getTimeZone("GMT")
    Log.d("235",sdfDate.format(dt))
    Log.d("235",sdfDtTime.format(dt))


    val sdfTime = SimpleDateFormat("hh:mm a")
    sdfTime.timeZone = java.util.TimeZone.getTimeZone("GMT")


    return sdfDtTime.format(dt)
}
