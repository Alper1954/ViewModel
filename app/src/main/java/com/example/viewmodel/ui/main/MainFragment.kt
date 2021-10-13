package com.example.viewmodel.ui.main

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.viewmodel.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout XML file and return a binding object instance
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resultText.text = viewModel.result.toString()

        // Set up a key listener on the EditText field to listen for "enter" button presses
        //binding.dollartextEditText.setOnKeyListener { view, i, _ -> handleKeyEvent(view, i) }
        binding.dollartextEditText.setOnKeyListener { v, i, _ -> handleKeyEvent(v, i) }

        binding.convertButton.setOnClickListener {
            if(binding.dollartextEditText.text.toString().isNotEmpty()) {
                viewModel.setAmount(binding.dollartextEditText.text.toString())
                binding.resultText.text = viewModel.result.toString()
            }else{
                binding.resultText.text = "No Value"
            }
        }
    }

    /*
    * Key listener for hiding the keyboard when the "Enter" button is tapped .
    */
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}


