package com.platziconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.platziconf.R
import com.platziconf.model.Location
import kotlinx.android.synthetic.main.fragment_location_detalis_dialog.*

class LocationDetailsDialogFragment : DialogFragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detalis_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbLocationDetails.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_baseline_close)
        tbLocationDetails.setTitleTextColor(Color.WHITE)
        tbLocationDetails.setNavigationOnClickListener {
            dismiss()
        }

        val location = Location()

        tvDetailLocationName.text = Location().name
        tvDetailLocationAddress.text = Location().address
        tvDetailLocationPhone.text = Location().phone
        tvDetailLocationLink.text = Location().website

        tvDetailLocationPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${location.phone}")
            }
            startActivity(intent)
        }

        tvDetailLocationLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(location.website)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}