package li2.plp.imperative1.command.atom;

import li2.plp.expressions2.expression.ExpNotEquals;
import li2.plp.expressions2.expression.ExpRem;
import li2.plp.expressions2.expression.ValorInteiro;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.command.IfThenElse;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.util.Logger;

public class ImplicitePredicate implements Comando {
	private ExpRem expressao;

	private Comando comandoThen;

	private Comando comandoElse;

	public ImplicitePredicate(ExpRem expressao, Comando comandoThen, Comando comandoElse) {
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
		Logger.getInstance().append("O átomo " + this + " foi trocado por if " + expressao.toString() + " != 0 then "
				+ comandoThen.toString() + " else " + comandoElse.toString() + ";");

		this.comandoThen = comandoThen.corrigir();
		this.comandoElse = comandoElse.corrigir();
		return new IfThenElse(new ExpNotEquals(expressao, new ValorInteiro(0)), comandoThen, comandoElse);
	}

	public String toString() {
		return "if " + expressao.toString() + " then " + comandoThen.toString() + " else " + comandoElse.toString();
	}
}
