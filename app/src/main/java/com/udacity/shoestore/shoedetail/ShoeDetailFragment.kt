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

        binding.btnSave.setOnClickListener { view ->
            var name = ""
            var size = 0.0
            var company = ""
            var description = ""

            binding.edtShoeName.text?.let {
                name = it.toString()
            }

            binding.edtShoeSize.text?.toString()?.toDouble()?.let {
                size = it
            }

            binding.edtCompany.text?.toString()?.let {
                company = it
            }

            binding.edtDescription.text?.toString()?.let {
                description = it
            }

            // Should enable/disable button in this, but skip it
            if (name.isNotEmpty() && size != 0.0 && company.isNotEmpty()) { // Description can be empty
                viewModel.addShoe(name = name, size = size, company = company, description = description)
                Navigation.findNavController(view).popBackStack()
            }
        }

        return binding.root
    }
}