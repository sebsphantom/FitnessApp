package com.sebs.fitnessapp.ui.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebs.fitnessapp.data.remote.model.LegendDto
import com.sebs.fitnessapp.databinding.LegendElementBinding

class LegendAdapter(
    private val legend: MutableList<LegendDto>,
    private val onLegendDto: (LegendDto) -> Unit
): RecyclerView.Adapter<LegendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder{
        val binding = LegendElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegendViewHolder(binding)
    }

    override fun getItemCount(): Int = legend.size

    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {

        val legend = legend[position]

        holder.bind(legend)

        holder.itemView.setOnClickListener {
            //Para los clicks en las leyendas
            onLegendDto(legend)
        }

    }


}

