package com.platziconf.view.adapter

import com.platziconf.model.Speaker

interface SpeakerListener {
    open fun onSpeakerClick(speaker: Speaker, position: Int){

    }
}