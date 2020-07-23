package com.example.task2app.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.task2app.R

class ArtistsAdapter(c: Context): BaseAdapter() {
    val mContext: Context = c
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var returnView: View
        returnView = if (convertView == null){
            val layoutInflater = LayoutInflater.from(mContext)
            layoutInflater.inflate(R.layout.artist_item, null)
        }else{
            convertView
        }
        val current_background = returnView.findViewById<ImageView>(R.id.artist_background)
        val current_album = returnView.findViewById<ImageView>(R.id.artist_profile)
        current_background.setImageResource(backgrounds[position])
        current_album.setImageResource(album_art[position])
        return returnView
    }

    override fun getItem(position: Int): Any {
        return Any()
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return backgrounds.size
    }

    val backgrounds: ArrayList<Int> = arrayListOf(R.drawable.background_0,
        R.drawable.background_1, R.drawable.background_2_, R.drawable.background_3_,
        R.drawable.background_4_, R.drawable.background_5_, R.drawable.background_6_,
        R.drawable.background_7_, R.drawable.background_8_, R.drawable.background_9_ )
    val album_art: ArrayList<Int> = arrayListOf(R.drawable.album_art_0,
        R.drawable.album_art_1_, R.drawable.album_art_2_, R.drawable.album_art_3_,
        R.drawable.album_art_4_, R.drawable.album_art_5_, R.drawable.album_art_6_,
        R.drawable.album_art_7_, R.drawable.album_art_8_, R.drawable.album_art_7_)
}