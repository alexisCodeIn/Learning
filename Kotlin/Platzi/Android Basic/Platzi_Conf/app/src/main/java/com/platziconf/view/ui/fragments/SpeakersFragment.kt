package com.platziconf.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.platziconf.R
import com.platziconf.model.Speaker
import com.platziconf.view.adapter.SpeakerAdapter
import com.platziconf.view.adapter.SpeakerListener
import com.platziconf.viewmodel.SpeakerViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_speakers.*


class SpeakersFragment : Fragment(), SpeakerListener {

    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakerViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SpeakerViewModel::class.java)
        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeakers.apply{
            layoutManager = GridLayoutManager(context,2)
            adapter = speakerAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.listSchedule.observe(viewLifecycleOwner, Observer<List<Speaker>>{schedule ->
            speakerAdapter.updateData(schedule)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null){
                rlBaseSpeaker.visibility = View.INVISIBLE
            }
        })
    }

    override fun onSpeakerClick(speaker: Speaker,position: Int){
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.SpeakersDetailFragmentDialog, bundle)
    }

}