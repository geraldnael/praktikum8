    package com.ifs21015.pampraktikum8

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.ifs21015.pampraktikum8.databinding.FragmentHomeBinding

    class HomeFragment : Fragment() {
        private lateinit var binding: FragmentHomeBinding
        private lateinit var instaAdapter: InstaAdapter
        private lateinit var pictAdapter: PictAdapter
        private val instaDataList: List<Int> = listOf(
            R.drawable.deak,
            R.drawable.boy,
            R.drawable.gerry,
            R.drawable.dastin,
            R.drawable.rafa,
            R.drawable.ciko,
            R.drawable.david,
            R.drawable.robert
            // Tambahkan sumber gambar lainnya di sini
        )
        private val pictDataList: List<Int> = listOf(
            R.drawable.deak,
            R.drawable.boy,
            R.drawable.gerry,
            R.drawable.dastin,
            R.drawable.rafa,
            R.drawable.ciko,
            R.drawable.david,
            R.drawable.robert
            // Tambahkan sumber gambar lainnya di sini
        )

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // Inisialisasi RecyclerView dan Adapter untuk InstaAdapter
            instaAdapter = InstaAdapter(requireContext(), instaDataList)
            binding.recyclerView.adapter = instaAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            // Inisialisasi RecyclerView dan Adapter untuk PictAdapter
            pictAdapter = PictAdapter(requireContext(), pictDataList)
            binding.recyclerView2.adapter = pictAdapter
            binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        }


        companion object {
            const val EXTRA_MESSAGE = "extra_message"
        }
    }
