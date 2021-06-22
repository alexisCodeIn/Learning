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
import androidx.recyclerview.widget.LinearLayoutManager
import com.platziconf.R
import com.platziconf.model.Conference
import com.platziconf.model.Speaker
import com.platziconf.view.adapter.ScheduleAdapter
import com.platziconf.view.adapter.ScheduleListener
import com.platziconf.view.adapter.SpeakerListener
import com.platziconf.viewmodel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*


class ScheduleFragment: Fragment(), ScheduleListener  {

    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()

        scheduleAdapter = ScheduleAdapter(this)

        rvSchedule.apply{
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = scheduleAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.listSchedule.observe(viewLifecycleOwner, Observer<List<Conference>>{schedule ->
            scheduleAdapter.updateData(schedule)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null){
                rlBaseSchedule.visibility = View.INVISIBLE
            }
        })
    }

        override fun onClickListener(conference:Conference, position: Int){
            val bundle = bundleOf("conference" to conference)
            findNavController().navigate(R.id.ScheduleDetailFragmentDialog, bundle)
        }

}