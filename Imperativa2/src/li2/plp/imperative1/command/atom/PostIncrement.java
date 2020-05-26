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
import li2.plp.imperative2.util.Logger;

public class PostIncrement implements Atribuicao {

	private Id id1;
	private Id id2;

	public PostIncrement(Id id1, Id id2) {
		this.id1 = id1;
		this.id2 = id2;
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
		Logger.getInstance().append("O átomo " + this + " foi trocado por " + id2.toString() + " += 1; "
				+ id1.toString() + " = " + id2.toString() + ";");

		return new SequenciaComando(new AtribuicaoSimples(id1, id2), new AtribuicaoSimples(id2, getExpressao()))
				.corrigir();
	}

	@Override
	public Expressao getExpressao() {
		return new ExpSoma(id2, new ValorInteiro(1));
	}

	public String toString() {
		return id1.toString() + " := " + id2.toString() + "++;";
	}
}
