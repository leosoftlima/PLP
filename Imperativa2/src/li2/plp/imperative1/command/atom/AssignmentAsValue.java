package li2.plp.imperative1.command.atom;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.command.Atribuicao;
import li2.plp.imperative1.command.AtribuicaoSimples;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.command.SequenciaComando;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class AssignmentAsValue implements Atribuicao {
	private Id id;
	private Atribuicao atribuicao;

	public AssignmentAsValue(Id id, Atribuicao atribuicao) {
		this.id = id;
		this.atribuicao = atribuicao;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return false;
	}

	@Override
	public Comando corrigir() {
		return new SequenciaComando(this.atribuicao, new AtribuicaoSimples(id, getExpressao())).corrigir();
	}

	@Override
	public Expressao getExpressao() {
		return this.atribuicao.getExpressao();
	}

}
