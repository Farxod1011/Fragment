package uz.farxod.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.farxod.fragment.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textviewSingUp.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, SingUpFragment()).addToBackStack(SingUpFragment().toString()).commit()
        }
        val editText = binding.editTextUsername

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
                if (binding.editTextUsername.length()<3){
                    binding.textviewHelper.text = "Username don't short 3-symbols!"
                }
                else binding.textviewHelper.text = ""
            }

            override fun afterTextChanged(s: Editable?) {
                // Вызывается после изменения текста
            }
        })

        binding.buttonEnter.setOnClickListener {
            var str = "STR"
            val bundle = Bundle()
            val resultFragment = ResultFragment()
            bundle.putString("path", str)
            resultFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, ResultFragment()).addToBackStack(ResultFragment().toString()).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}