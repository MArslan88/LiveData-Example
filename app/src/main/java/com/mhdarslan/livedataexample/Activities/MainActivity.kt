package com.mhdarslan.livedataexample.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhdarslan.livedataexample.Adapters.NoteAdapter
import com.mhdarslan.livedataexample.ViewModels.NoteViewModel
import com.mhdarslan.livedataexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModel: NoteViewModel
//    private val noteViewModel: NoteViewModel by viewModels()
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteAdapter = NoteAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = noteAdapter

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.notes.observe(this){ notes ->
            noteAdapter.submitList(notes)
        }

        binding.btnAdd.setOnClickListener {
            val text = binding.editText.text.toString()
            noteViewModel.addNote(text)
            binding.editText.text.clear()
        }


    }
}