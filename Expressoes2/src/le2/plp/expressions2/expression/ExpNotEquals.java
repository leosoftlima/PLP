package le2.plp.expressions2.expression;

import le2.plp.expressions1.util.Tipo;
import le2.plp.expressions1.util.TipoPrimitivo;
import le2.plp.expressions2.memory.AmbienteCompilacao;
import le2.plp.expressions2.memory.AmbienteExecucao;
import le2.plp.expressions2.memory.VariavelJaDeclaradaException;
import le2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpNotEquals extends ExpBinaria {

	public ExpNotEquals(Expressao esq, Expressao dir) {
		super(esq, dir, "!=");
	}

	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorConcreto esq = (ValorConcreto) getEsq().avaliar(amb);
		ValorConcreto dir = (ValorConcreto) getDir().avaliar(amb);
		return new ValorBooleano(!esq.isEquals(dir));
	}

	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoPrimitivo.BOOLEANO;
	}

	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return getEsq().getTipo(amb).eIgual(getDir().getTipo(amb));
	}

	@Override
	public ExpBinaria clone() {
		return new ExpNotEquals(esq.clone(), dir.clone());
	}

}
