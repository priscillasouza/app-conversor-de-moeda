package com.example.conversordemoedas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.conversordemoedas.databinding.FragmentCurrencyConverterBinding
import java.math.BigDecimal

class CurrencyConverterFragment : Fragment() {

    private var _binding: FragmentCurrencyConverterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener()
    }

    private fun listener() {
        binding.apply {
            buttonConverter.setOnClickListener {
                convertValue()
            }
        }
    }

    private fun convertValue() {
        binding.apply {
            val valueReal: BigDecimal = edittextValueReal.text.toString().toBigDecimal()
            val quoteDolar: BigDecimal = edittextQuoteDolar.text.toString().toBigDecimal()
            val valueConverted: BigDecimal = valueReal / quoteDolar

            // atribui o valor convertido para a textView que vai apresentar o resultado
            textviewValueConverted.text = valueConverted.toPlainString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

