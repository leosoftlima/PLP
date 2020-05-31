package li2.plp.imperative1.command.atom;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.Ternario;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.command.Atribuicao;
import li2.plp.imperative1.command.AtribuicaoSimples;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.command.IfThenElse;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.util.Logger;

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
		IfThenElse novoComando = new IfThenElse(getExpressao(), getAtribuicao(id, ternario.getExpressaoInterrogacao()),
				getAtribuicao(id, ternario.getExpressaoDoisPontos()));

		Logger.getInstance().append("O átomo " + this + " foi trocado por " + novoComando.toString());

		return novoComando.corrigir();
	}

	@Override
	public Id getId() {
		return this.id;
	}

	@Override
	public Expressao getExpressao() {
		return this.ternario.getExpressao();
	}

	public String toString() {
		return id.toString() + " := " + ternario.toString();
	}

	private Atribuicao getAtribuicao(Id id, Expressao expressao) {
		if (expressao instanceof Ternario) {
			return new ConditionalOperator(id, (Ternario) expressao);
		} else {
			return new AtribuicaoSimples(id, expressao);
		}
	}
}
