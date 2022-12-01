package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    override fun onCleared() {
        super.onCleared()
        Timber.i("View Model cleared")
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        var data = mutableListOf<Shoe>()
        _shoeList.value?.let {
            data = it
        }
        val shoe = Shoe(name, size, company, description)
        data.add(shoe)
        _shoeList.value = data
    }

}