package com.platziconf.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.platziconf.R
import com.platziconf.model.Conference
import com.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_location_detalis_dialog.*
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import java.text.SimpleDateFormat
import java.util.*

class ScheduleDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbConferenceDetails.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_baseline_close)
        tbConferenceDetails.setTitleTextColor(Color.WHITE)
        tbConferenceDetails.setNavigationOnClickListener {
            dismiss()
        }

        val conference = arguments?.getSerializable("conference")as Conference

        tvDetailConferenceName.text = conference.title
        tvDetailConferenceSpeakerName.text = conference.speaker
        val pattern = "dd/MM/yyyy hh:mm a"
        val simpleDF = SimpleDateFormat("dd/MM/yyyy\nhh:mm a")
        val date = simpleDF.format(conference.dateTime)
        tvDetailConferenceHour.text = date
        tvDetailConferenceDescription.text = conference.description
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
}