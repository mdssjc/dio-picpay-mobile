package br.com.dio.picpayclone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.dio.picpayclone.R
import br.com.dio.picpayclone.data.UsuarioLogado

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (UsuarioLogado.isUsuarioNaoLogado()) {
            vaiParaLogin()
        }
    }

    private fun vaiParaLogin() {
        val direcao = HomeFragmentDirections.actionGlobalLoginFragment()
        val controlador = findNavController()
        controlador.navigate(direcao)
    }
}