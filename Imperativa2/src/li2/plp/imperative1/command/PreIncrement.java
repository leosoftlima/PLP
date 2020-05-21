package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class PreIncrement implements Atribuicao {

	private Id id;

	private Expressao expressao;

	public PreIncrement(Id id, Expressao expressao) {
		this.id = id;
		this.expressao = expressao;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		// TODO Auto-generated method stub
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressao.checaTipo(ambiente) && id.getTipo(ambiente).eIgual(expressao.getTipo(ambiente));
	}
    
	@Override
	public Id getId() {
		return id;
	}
	
}
