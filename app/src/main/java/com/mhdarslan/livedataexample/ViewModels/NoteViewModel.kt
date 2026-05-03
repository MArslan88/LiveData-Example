package com.mhdarslan.livedataexample.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mhdarslan.livedataexample.Models.Note

class NoteViewModel : ViewModel() {
    private val noteList = mutableListOf<Note>()
    private val _notes = MutableLiveData<List<Note>>()

    // Expose the LiveData to the UI
    val notes : LiveData<List<Note>> get() = _notes
    private var counter = 0


    fun addNote(text: String){
        if(text.isNotEmpty()){
            noteList.add(Note(counter++, text))
            _notes.value = noteList
        }
    }

}