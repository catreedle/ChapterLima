package com.example.chapterlima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


// step 3 kirim data dari activity ke fragment, implement interface di fragment
class OnBoardImageOneFragment : Fragment(), MainActivity.OnSendDataToFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // step 5 kirim data dari activity ke fragment, isi variable listener di activity
        (activity as MainActivity).listener = this

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_board1, container, false)
    }

    // step 4 kirim data dari activity ke fragment, override fungsi pada interface
    override fun onDataSend(input: String) {
        Toast.makeText(requireContext(), "data : $input", Toast.LENGTH_SHORT).show()
    }

}