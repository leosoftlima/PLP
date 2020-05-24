package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.Ternario;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class ConditionalOperator implements Atribuicao {
	private Id id;
	private Ternario ternario;

	public ConditionalOperator(Id id, Ternario ternario) {
		this.id = id;
		this.ternario = ternario;
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
		return new IfThenElse(getExpressao(), getAtribuicao(id, ternario.getExpressaoInterrogacao()),
				getAtribuicao(id, ternario.getExpressaoDoisPontos())).corrigir();
	}

	@Override
	public Expressao getExpressao() {
		return this.ternario.getExpressao();
	}

	private Atribuicao getAtribuicao(Id id, Expressao expressao) {
		if (expressao instanceof Ternario) {
			return new ConditionalOperator(id, (Ternario) expressao);
		} else {
			return new AtribuicaoSimples(id, expressao);
		}
	}
}
