package com.example.hbomaxapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.hbomaxapp.databinding.CardDesignBinding

class MoviesAdapter (var mContext: Context, var moviesList: List<Movies>)
    : RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        var binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = moviesList.get(position)
        val t = holder.design
        t.textViewMovieDesc.text = movie.desc
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