package br.com.dio.picpayclone.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.dio.picpayclone.R
import br.com.dio.picpayclone.data.Usuario
import br.com.dio.picpayclone.data.UsuarioLogado
import br.com.dio.picpayclone.ui.componente.Componente
import br.com.dio.picpayclone.ui.componente.ComponenteViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment() {

    private val componenteViewModel: ComponenteViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        componenteViewModel.temComponente = Componente(bottomNavigation = false)
        configurarBotaoLogin()
    }

    private fun configurarBotaoLogin() {
        button.setOnClickListener {
            UsuarioLogado.usuario = Usuario("joaovf")
            vaiParaHome()
        }
    }

    private fun vaiParaHome() {
        val direcao = LoginFragmentDirections.actionLoginFragmentToNavigationHome()
        val controlador = findNavController()
        controlador.navigate(direcao)
    }
}