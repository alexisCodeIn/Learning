package com.platziconf.viewmodel

import android.telecom.Conference
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platziconf.network.Callback
import com.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<com.platziconf.model.Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase(){
        firestoreService.getSpeakers(object : Callback<List<com.platziconf.model.Speaker>>{
            override fun onSuccess(result: List<com.platziconf.model.Speaker>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}