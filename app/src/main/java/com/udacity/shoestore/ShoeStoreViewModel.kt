package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel : ViewModel() {

    var name: String = ""
    var sizeText: String = ""
    var company: String = ""
    var description: String = ""

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    override fun onCleared() {
        super.onCleared()
        Timber.i("View Model cleared")
    }

    fun addShoe() {
        var data = mutableListOf<Shoe>()
        _shoeList.value?.let {
            data = it
        }

        val size = sizeText.toDouble()

        // Should enable/disable button in this, but skip it
        if (name.isNotEmpty() && size != 0.0 && company.isNotEmpty()) {
            val shoe = Shoe(name, size, company, description)
            data.add(shoe)
            _shoeList.value = data
        }
    }

}