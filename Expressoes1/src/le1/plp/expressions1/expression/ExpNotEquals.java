package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions1.util.TipoPrimitivo;
import le1.plp.expressions2.memory.AmbienteCompilacao;
import le1.plp.expressions2.memory.AmbienteExecucao;

public class ExpNotEquals extends ExpBinaria {

	public ExpNotEquals(Expressao esq, Expressao dir) {
		super(esq, dir, "!=");
	}

	public Valor avaliar(AmbienteExecucao amb) {
		ValorConcreto esq = (ValorConcreto) getEsq().avaliar(amb);
		ValorConcreto dir = (ValorConcreto) getDir().avaliar(amb);
		return new ValorBooleano(!esq.isEquals(dir));
	}

	public Tipo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.BOOLEANO;
	}

	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) {
		return getEsq().getTipo(amb).eIgual(getDir().getTipo(amb));
	}

}
