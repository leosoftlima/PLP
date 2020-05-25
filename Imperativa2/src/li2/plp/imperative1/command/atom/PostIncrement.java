package li2.plp.imperative1.command.atom;

import li2.plp.expressions2.expression.ExpSoma;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.ValorInteiro;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.command.Atribuicao;
import li2.plp.imperative1.command.AtribuicaoSimples;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.command.SequenciaComando;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class PostIncrement implements Atribuicao {
	
	private Id id;

	private Expressao expressao;

	public PostIncrement(Id id, Expressao expressao) {
		this.id = id;
		this.expressao = expressao;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return false;
	}

	@Override
	public Comando corrigir() {
		return new SequenciaComando(new AtribuicaoSimples(id, getExpressao() ), new AtribuicaoSimples(new Id(getExpressao().toString()), new ExpSoma(expressao, new ValorInteiro(1)))).corrigir();
	}

	@Override
	public Expressao getExpressao() {
		return this.expressao;
	}

	
}
