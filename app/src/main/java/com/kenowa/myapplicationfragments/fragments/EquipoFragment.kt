package com.kenowa.myapplicationfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kenowa.myapplicationfragments.R

/*
 * A simple [Fragment] subclass.
 * Use the [EquipoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EquipoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipo, container, false)
    }

}