package com.udacity.shoestore.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeStoreViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeStoreViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.btnCancel.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        binding.viewModel = viewModel

        binding.btnSave.setOnClickListener { view ->
            viewModel.addShoe()
            Navigation.findNavController(view).popBackStack()
        }

        return binding.root
    }
}