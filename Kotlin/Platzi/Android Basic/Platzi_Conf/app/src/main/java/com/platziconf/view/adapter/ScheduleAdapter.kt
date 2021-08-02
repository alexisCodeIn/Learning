package com.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platziconf.R
import com.platziconf.model.Conference
import com.platziconf.view.ui.fragments.ScheduleFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    var listConference = ArrayList<com.platziconf.model.Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule,parent,false))

    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeakerName.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDateFormat = SimpleDateFormat("hh:mm")
        val simpleDateFormatAmPm = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.dateTime
        val hourFormat = simpleDateFormat.format(conference.dateTime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceHourAMPM.text = simpleDateFormatAmPm.format(conference.dateTime)

        holder.itemView.setOnClickListener {
            scheduleListener.onClickListener(conference,position)
        }

    }

    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeakerName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeakerName)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceHourAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleHourAMPM)
    }
}