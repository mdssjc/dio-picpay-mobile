package br.com.dio.picpayclone.ui.transacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.dio.picpayclone.R
import kotlinx.android.synthetic.main.fragment_transacao.*
import kotlinx.android.synthetic.main.item_contato.textViewNomeCompleto

class TransacaoFragment : Fragment() {

    private val argumentos by navArgs<TransacaoFragmentArgs>()
    private val usuario by lazy { argumentos.usuario }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transacao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewNome.text = usuario.login
        textViewNomeCompleto.text = usuario.nomeCompleto
    }
}