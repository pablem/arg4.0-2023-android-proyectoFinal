package com.example.comparadas.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comparadas.model.Comparator
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val comparator: LiveData<Comparator> get() = _comparator
    private var _comparator = MutableLiveData<Comparator>(Comparator("..."))

    fun compare(txt1: String, txt2: String) {
        val result = txt1 == txt2
        updateCompareResult(result)
    }

    private fun updateCompareResult(result: Boolean) {
        val mesagg =
            if(result)
                "Son iguales!"
            else
                "Son Diferentes..."
                //R.string.message_different
        _comparator.value = Comparator(mesagg)
    }


}