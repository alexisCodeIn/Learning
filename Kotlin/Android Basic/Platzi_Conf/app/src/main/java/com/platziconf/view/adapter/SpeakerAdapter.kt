package com.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platziconf.R
import com.platziconf.model.Speaker
import kotlin.collections.ArrayList

class SpeakerAdapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>(){

    var listSpeaker = ArrayList<com.platziconf.model.Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker,parent,false))

    override fun getItemCount() = listSpeaker.size

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {

        val speaker = listSpeaker[position] as Speaker
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.workplace

        Glide.with(holder.ivSpeakerPhoto).load(speaker.image).apply(RequestOptions.circleCropTransform()).into(holder.ivSpeakerPhoto)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClick(speaker,position)
        }
    }

    fun updateData(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvSpeakerName)
        val tvSpeakerJob = itemView.findViewById<TextView>(R.id.tvSpeakerJob)
        val ivSpeakerPhoto = itemView.findViewById<ImageView>(R.id.tvSpeakerPhoto)
    }

}