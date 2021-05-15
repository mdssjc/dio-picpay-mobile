package br.com.dio.picpayclone.ui.pagar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.dio.picpayclone.R
import br.com.dio.picpayclone.data.Usuario
import kotlinx.android.synthetic.main.fragment_pagar.*
import org.koin.android.viewmodel.ext.android.viewModel

class PagarFragment : Fragment() {

    private val pagarViewModel: PagarViewModel by viewModel()
    private val controlador by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pagar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRecyclerView()
    }

    private fun configurarRecyclerView() {
        val usuarios = listOf(
            Usuario(login = "mdssjc", nomeCompleto = "Marcelo dos Santos"),
            Usuario(login = "joaov", nomeCompleto = "João Vitor"),
            Usuario(login = "cicero", nomeCompleto = "Cicero")
        )
        recyclerView.adapter = PagarAdapter(usuarios) {
            vaiParaTransacao(it)
        }
    }

    private fun vaiParaTransacao(usuario: Usuario) {
        val direcao =
            PagarFragmentDirections.actionNavigationPagarToTransacaoFragment(usuario)
        controlador.navigate(direcao)
    }
}