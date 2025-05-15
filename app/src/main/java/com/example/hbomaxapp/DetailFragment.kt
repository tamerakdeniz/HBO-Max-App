package com.example.hbomaxapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.hbomaxapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val movie = bundle.movieObject

        binding.ivMovie.setImageResource(
            resources.getIdentifier(movie.image,"drawable",requireContext().packageName)
        )

        binding.textViewDesc.text = movie.desc
        binding.textViewCat.text = movie.cat

        return binding.root
    }
}