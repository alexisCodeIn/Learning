package com.platziconf.view.adapter

import com.platziconf.model.Conference
import com.platziconf.model.Speaker

interface ScheduleListener{
    open fun onClickListener(conference: Conference, position: Int){

    }
}