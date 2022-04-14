package com.example.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.runningapp.R
import com.example.runningapp.other.Constants.KEY_NAME
import com.example.runningapp.other.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPref: SharedPreferences

    private lateinit var etName: TextInputEditText
    private lateinit var etWeight: TextInputEditText
    private lateinit var btnApplyChanges: Button
//    private lateinit var tvToolbar: MaterialTextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.etName)
        etWeight = view.findViewById(R.id.etWeight)
        btnApplyChanges= view.findViewById(R.id.btnApplyChanges)
//        tvToolbar = requireActivity().findViewById(R.id.tvToolbarTitle)

        loadFieldFromSharedPref()

        btnApplyChanges.setOnClickListener{
            val success = applyChangesToSharedPref()
            if (success) {
                Snackbar.make(view, "Changes Saved", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Please fill out all fields", Snackbar.LENGTH_LONG).show()
            }
        }

    }

    private fun loadFieldFromSharedPref() {
        val name = sharedPref.getString(KEY_NAME, "")
        val weight = sharedPref.getFloat(KEY_WEIGHT,80f)

        etName.setText(name)
        etWeight.setText(weight.toString())
    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()

        if (nameText.isEmpty() || weightText.isEmpty()) {
            return false
        }

        sharedPref.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT,weightText.toFloat())
            .apply()

        val toolbarText = "Let's go $nameText"
//        tvToolbar.text = toolbarText
        return true
    }
}