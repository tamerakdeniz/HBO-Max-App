package com.example.hbomaxapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.hbomaxapp.databinding.FeaturedCardDesignBinding

class MoviesFeaturedAdapter (var mContext: Context, var moviesList: List<Movies>)
    : RecyclerView.Adapter<MoviesFeaturedAdapter.FeaturedCardDesignHolder>(){

    inner class FeaturedCardDesignHolder(var design: FeaturedCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedCardDesignHolder {
        var binding = FeaturedCardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FeaturedCardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturedCardDesignHolder, position: Int) {
        val movie = moviesList.get(position)
        val t = holder.design
        t.imageViewMovie.setImageResource(
            mContext.resources.getIdentifier(movie.image,"drawable",mContext.packageName)
        )

        t.cardViewMovie.setOnClickListener{
            val transition = HomePageFragmentDirections.detailTransition(movieObject = movie)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}