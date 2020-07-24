package com.example.task2app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task2app.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeRecyclerAdaper.Interaction {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var discoverAdaper: HomeRecyclerAdaper
    private lateinit var popularAdaper: HomeRecyclerAdaper
//    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var host: TabHost
    private lateinit var spec: TabHost.TabSpec

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.HORIZONTAL)

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        host = requireActivity().findViewById<TabHost>(R.id.tabHost).also {
            it.setup()
            //series
            spec = it.newTabSpec("series")
            spec.setContent(R.id.Series)
            spec.setIndicator("Series")
            it.addTab(spec)
            val tv: TextView = it.tabWidget.getChildAt(it.currentTab).findViewById(android.R.id.title)
            tv.isAllCaps = false
            tv.textSize = 13F
            //music
            spec = it.newTabSpec("music")
            spec.setContent(R.id.Music)
            spec.setIndicator("Music")
            it.addTab(spec)
            val tv1: TextView = it.tabWidget.getChildAt(it.currentTab+1).findViewById(android.R.id.title)
            tv1.isAllCaps = false
            tv1.textSize = 13F
            //my collection
            spec = it.newTabSpec("my collection")
            spec.setContent(R.id.myCollection)
            spec.setIndicator("My Collection")
            it.addTab(spec)
            val tv2: TextView = it.tabWidget.getChildAt(it.currentTab+2).findViewById(android.R.id.title)
            tv2.isAllCaps = false
            tv2.textSize = 13F
        }


        initRecyclerviews()
        discoverAdaper.submitList(homeViewModel.discoverItems)
        popularAdaper.submitList(homeViewModel.popularItems)
    }

    private fun initRecyclerviews(){
        discoverRv.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            discoverAdaper = HomeRecyclerAdaper(this@HomeFragment)
            adapter = discoverAdaper
//            addItemDecoration(itemDecoration)
        }

        popularRv.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            popularAdaper = HomeRecyclerAdaper(this@HomeFragment)
            adapter = popularAdaper
        }
    }

    override fun onItemSelected(position: Int, item: HomeModel) {
        //we ain't implementing nothing...
    }
}
