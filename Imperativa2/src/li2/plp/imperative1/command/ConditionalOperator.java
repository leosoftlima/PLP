package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Id;
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
		ambiente.changeValor(id, ternario.avaliar(ambiente));
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {	
		return ternario.checaTipo(ambiente) && id.getTipo(ambiente).eIgual(ternario.getTipo(ambiente));
	}

	@Override
	public Id getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
