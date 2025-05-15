package com.example.hbomaxapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hbomaxapp.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        val movieList = ArrayList<Movies>()

        val m1 = Movies(1, "Dune",
            "dune",
            "In a far future, Paul Atreides leads nomadic tribes\nin a battle to control the desert planet Arrakis.",
            "Epic Science Fiction")

        val m2 = Movies(2, "Harry Potter",
            "harrypotter",
            "A young wizard discovers his magical heritage\nand battles the dark lord Voldemort across seven years at Hogwarts.",
            "Fantasy, Adventure")

        val m3 = Movies(3, "House of the Dragon",
            "houseofdragon",
            "Set 200 years before Game of Thrones, it chronicles\nthe rise of House Targaryen and the Targaryen civil war.",
            "Fantasy, Drama")

        val m4 = Movies(4, "Inception",
            "inception",
            "A thief who enters people's dreams to steal secrets\nis hired to plant an idea in a CEO's mind.",
            "Science Fiction, Action, Thriller")

        val m5 = Movies(5, "Joker",
            "joker",
            "In Gotham City, a failed comedian descends into madness\nand becomes the infamous criminal mastermind, Joker.",
            "Psychological Thriller, Drama")

        val m6 = Movies(6, "The Last of Us",
            "lastofus",
            "A smuggler escorts a teenage girl across a post-apocalyptic US\nwhere a fungal infection has decimated society.",
            "Post-Apocalyptic Drama, Action")

        val m7 = Movies(7, "The Lord of the Rings",
            "lordoftherings",
            "A hobbit and his companions embark on a quest to destroy\na powerful ring and defeat the dark lord Sauron.",
            "Fantasy, Adventure, Epic")

        val m8 = Movies(8, "Prophecy",
            "prophecy",
            "A young man discovers a prophecy that may determine\nthe fate of the world—and his role in it.",
            "Fantasy, Mystery")

        val m9 = Movies(9, "300: Rise of an Empire",
            "rise",
            "Greek general Themistokles leads the charge against\ninvading Persian forces led by mortal-turned-god Xerxes.",
            "Action, War, Historical Epic")

        val m10 = Movies(10, "The Penguin",
            "thepenguin",
            "A gritty crime saga following the rise of Oswald Cobblepot,\naka The Penguin, in Gotham's underworld.",
            "Crime Drama")

        val m11 = Movies(11, "The Prestige",
            "theprestige",
            "Two rival magicians engage in a deadly battle to create\nthe ultimate stage illusion in 19th century London.",
            "Mystery, Thriller, Drama")

        val m12 = Movies(12, "Interstellar",
            "interstellar",
            "Earth's last chance to find a habitable planet\nbefore humanity faces extinction due to lack of resources.",
            "Epic Science Fiction")

        movieList.add(m1)
        movieList.add(m2)
        movieList.add(m3)
        movieList.add(m4)
        movieList.add(m5)
        movieList.add(m6)
        movieList.add(m7)
        movieList.add(m8)
        movieList.add(m9)
        movieList.add(m10)
        movieList.add(m11)
        movieList.add(m12)

        val shuffledMovieList = ArrayList(movieList).apply { shuffle() }
        val moviesAdapter = MoviesAdapter(requireContext(), shuffledMovieList)
        binding.moviesRv.adapter = moviesAdapter
        binding.moviesRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val shuffledMovieList2 = ArrayList(movieList).apply { shuffle() }
        val moviesFeaturedAdapter = MoviesFeaturedAdapter(requireContext(), shuffledMovieList2)
        binding.moviesFeaturedRv.adapter = moviesFeaturedAdapter
        binding.moviesFeaturedRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        return binding.root
    }
}