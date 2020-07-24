package com.example.task2app.ui.notifications

import android.graphics.Color.parseColor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.task2app.R

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var gridView: GridView
    private lateinit var artistsButton: Button
    private lateinit var usersButton: Button
    private lateinit var searchView: SearchView
    private lateinit var searchTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        gridView = root.findViewById(R.id.artists_gridview)
        artistsButton = root.findViewById(R.id.btn_artists)
        usersButton = root.findViewById(R.id.btn_users)
        searchView = root.findViewById(R.id.people_search)
        searchTextView = root.findViewById(R.id.search_text)
        gridView.adapter = ArtistsAdapter(this.requireContext())
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        artistsButton.setOnClickListener {
            it.setBackgroundColor(parseColor("#ffb43a38"))
            usersButton.setBackgroundColor(parseColor("#5C5858"))
        }
        usersButton.setOnClickListener {
            it.setBackgroundColor(parseColor("#ffb43a38"))
            artistsButton.setBackgroundColor(parseColor("#5C5858"))
        }
        searchView.setOnSearchClickListener {
            searchTextView.text = ""
        }
        searchView.setOnCloseListener {
            searchTextView.text = "Search people on BNG-TV"
            return@setOnCloseListener false
        }
    }
}
