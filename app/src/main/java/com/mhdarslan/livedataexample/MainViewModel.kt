package com.mhdarslan.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    // this is mutable live data 'factsLiveDataObject' so we don't want to give any outsource to give access of it so we make it private
    private val factsLiveDataObject = MutableLiveData<String>("This is a fact")

    // and make another live data 'factsLiveData' and that will be publicly accessible but it will be just a live data so it read only and it will get the
    // data of 'factsLiveDataObject'
    val factsLiveData : LiveData<String> get() = factsLiveDataObject

    fun updateLiveData(){
        factsLiveDataObject.value = "Another Fact"
    }
}