package com.example.runningapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runningapp.R
import com.example.runningapp.db.Run
import com.example.runningapp.other.TrackingUtility
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter: RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    inner class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivRunImage: ImageView = itemView.findViewById(R.id.ivRunImage)
        private val tvDate: MaterialTextView = itemView.findViewById(R.id.tvDate)
        private val tvAvgSpeed: MaterialTextView = itemView.findViewById(R.id.tvAvgSpeed)
        private val tvDistance: MaterialTextView = itemView.findViewById(R.id.tvDistance)
        private val tvTime: MaterialTextView = itemView.findViewById(R.id.tvTime)
        private val tvCalories: MaterialTextView = itemView.findViewById(R.id.tvCalories)


        fun bind(run: Run) {
            Glide.with(itemView).load(run.img).into(ivRunImage)

            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }

            val dateFormat = SimpleDateFormat("dd:mm:yy",Locale.getDefault())
            tvDate.text = dateFormat.format(calendar.time)

            val avgSpeed = "${run.avgSpeedInKMH}km/h"
            tvAvgSpeed.text = avgSpeed

            val distanceInKm = "${run.distanceInMeters/1000}km"
            tvDistance.text = distanceInKm

            tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

            val caloriesBurned = "${run.caloriesBurned}kcal"
            tvCalories.text = caloriesBurned

        }
    }

    val diffCallback = object : DiffUtil.ItemCallback<Run>(){
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
           return oldItem.runId == newItem.runId
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
           return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffCallback)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_run,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run = differ.currentList[position]
        holder.bind(run)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}