package sphe.inews.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sphe.inews.R
import sphe.inews.databinding.ItemCountryBinding
import sphe.inews.models.Country

class CountryAdapter(private var list: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    private lateinit var listener: CountryListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinder: ItemCountryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_country,
            parent,
            false
        )
        return  ViewHolder(viewBinder)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = list[position]

        holder.image.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,country.image))

        holder.title.text = country.countryName

        holder.itemView.setOnClickListener {
            listener.onItemCountryClick(country)
        }
    }

    fun setCountryClickListener(listener: CountryListener){
        this.listener = listener
    }

     class ViewHolder(@NonNull viewBinder: ItemCountryBinding): RecyclerView.ViewHolder(viewBinder.root){
        var image : ImageView = viewBinder.image
        var title :TextView  = viewBinder.title
    }

    interface CountryListener{
        fun onItemCountryClick(country: Country)
    }
}