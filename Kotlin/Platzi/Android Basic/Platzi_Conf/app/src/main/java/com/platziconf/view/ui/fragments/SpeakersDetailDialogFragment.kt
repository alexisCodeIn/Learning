package com.platziconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.platziconf.R
import com.platziconf.model.Conference
import com.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*
import java.text.SimpleDateFormat

class SpeakersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbSpeakerProfilePhoto.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_baseline_close)
        tbSpeakerProfilePhoto.setTitleTextColor(Color.WHITE)
        tbSpeakerProfilePhoto.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker")as Speaker

        Glide.with(ivDetailSpeakerPhoto.context).load(speaker.image).into(ivDetailSpeakerPhoto)

        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerTitle.text = speaker.jobTitle
        tvDetailSpeakerJob.text = speaker.workplace
        tvDetailSpeakerDescription.text = speaker.biography

        floatingActionButtonSpeakerTwitter.setOnClickListener{
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/$url")
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
