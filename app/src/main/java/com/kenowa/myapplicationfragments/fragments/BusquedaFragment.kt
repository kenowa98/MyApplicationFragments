package com.kenowa.myapplicationfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kenowa.myapplicationfragments.R

/*
 * A simple [Fragment] subclass.
 * Use the [BusquedaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusquedaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_busqueda, container, false)
    }

}