package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions1.util.TipoPrimitivo;
import le1.plp.expressions2.memory.AmbienteCompilacao;
import le1.plp.expressions2.memory.AmbienteExecucao;

public class ExpRem extends ExpBinaria {

	public ExpRem(Expressao esq, Expressao dir) {
		super(esq, dir, "%");
	}

	public Valor avaliar(AmbienteExecucao amb) {
		return new ValorInteiro(
				((ValorInteiro) getEsq().avaliar(amb)).valor() % ((ValorInteiro) getDir().avaliar(amb)).valor());
	}

	public Tipo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.INTEIRO;
	}

	protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente) {
		return (getEsq().getTipo(ambiente).eInteiro() && getDir().getTipo(ambiente).eInteiro());
	}

}
