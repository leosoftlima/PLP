package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.ExpNotEquals;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.ValorInteiro;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class ImplicitePredicate implements Comando {
	private Expressao expressao;

	private Comando comandoThen;

	private Comando comandoElse;

	public ImplicitePredicate(Expressao expressao, Comando comandoThen, Comando comandoElse) {
		this.expressao = expressao;
		this.comandoThen = comandoThen;
		this.comandoElse = comandoElse;
	}

	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return false;
	}

	@Override
	public Comando corrigir() {
		this.comandoThen = comandoThen.corrigir();
		this.comandoElse = comandoElse.corrigir();
		return new IfThenElse(new ExpNotEquals(expressao, new ValorInteiro(0)), comandoThen, comandoElse);
	}
}
