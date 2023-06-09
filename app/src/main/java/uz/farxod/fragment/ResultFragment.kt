package uz.farxod.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.farxod.fragment.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var filePath = "..."
        val bundle = arguments
        if (bundle != null) filePath = bundle.getString("path", "")

        Log.d("Tag", filePath)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}