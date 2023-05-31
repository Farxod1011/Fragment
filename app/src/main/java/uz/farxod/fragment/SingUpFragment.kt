package uz.farxod.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import uz.farxod.fragment.databinding.ActivityMainBinding
import uz.farxod.fragment.databinding.FragmentBlankBinding
import uz.farxod.fragment.databinding.FragmentSingupBinding

class SingUpFragment : Fragment() {

    private var _binding: FragmentSingupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSingupBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val username = binding.editTextUsername
        val password = binding.editTextPassword

        username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
                if (binding.editTextUsername.length()<3){
                    binding.textviewHelper.text = "Username don't short 3-symbols!"
                    binding.textviewHelper.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
                else binding.textviewHelper.text = ""
            }

            override fun afterTextChanged(s: Editable?) {
                // Вызывается после изменения текста
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
                val pass = binding.editTextPassword.text

                if (binding.editTextPassword.length()<4){
                    binding.textviewHelper.text = "Parol 4-ta simvoldan kam bo'lmasligi shart!"
                    binding.textviewHelper.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
                else if(pass.contains(Regex("[A-Z]")) && binding.editTextPassword.length()>4){
                    binding.textviewHelper.text = "Siz o'rtacha qiyinlikdagi parol tanladingiz."
                    binding.textviewHelper.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
                }
                else if(binding.editTextPassword.length()>7 && pass.contains(Regex("[A-Z\\d]") )) {
                    binding.textviewHelper.text = "Judaham ishonchli parol tanlandi"
                    binding.textviewHelper.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                }
                else {
                    binding.textviewHelper.text = "Parol judaham sodda"
                    binding.textviewHelper.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }

            }

            override fun afterTextChanged(s: Editable?) {
                // Вызывается после изменения текста
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}