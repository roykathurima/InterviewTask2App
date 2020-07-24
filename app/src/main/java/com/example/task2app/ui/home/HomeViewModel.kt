package com.example.task2app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task2app.R

class HomeViewModel : ViewModel() {

    val discoverItems: ArrayList<HomeModel> = arrayListOf(
        HomeModel(backgroundRid = R.drawable.audience_, starRid = R.drawable.star_, title = "No Guidance", description = "137k Views/Chris Brown"),
        HomeModel(backgroundRid = R.drawable.stock_photo_, starRid = R.drawable.star_, title = "Earfquake", description = "30k Views/The Creator"),
        HomeModel(backgroundRid = R.drawable.concert_, starRid = R.drawable.yellow_star_, title = "Mode for Eva", description = "130k Views/Beyonce Ft JayZ")
    )
    val popularItems: ArrayList<HomeModel> = arrayListOf(
        HomeModel(backgroundRid = R.drawable.blurry_, starRid = R.drawable.yellow_star_, title = "No Guidance", description = "137k Views/Chris Brown"),
        HomeModel(backgroundRid = R.drawable.cap2_, starRid = R.drawable.yellow_star_, title = "Earfquake", description = "30k Views/The Creator"),
        HomeModel(backgroundRid = R.drawable.charles_blue_, starRid = R.drawable.yellow_star_, title = "Mode for Eva", description = "130k Views/Beyonce Ft JayZ")
    )
    val suggestedItems: ArrayList<HomeModel> = arrayListOf(
        HomeModel(backgroundRid = R.drawable.audience_, starRid = R.drawable.yellow_star_, title = "No Guidance", description = "137k Views/Chris Brown"),
        HomeModel(backgroundRid = R.drawable.cap3_, starRid = R.drawable.yellow_star_, title = "Earfquake", description = "30k Views/The Creator"),
        HomeModel(backgroundRid = R.drawable.cap5_, starRid = R.drawable.star_, title = "Mode for Eva", description = "130k Views/Beyonce Ft JayZ")
    )

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
}