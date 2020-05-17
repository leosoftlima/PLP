package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class AssignmentAsValue implements Atribuicao {
	private Id id;
	private Atribuicao atribuicao;

	public AssignmentAsValue(Id id, Atribuicao atribuicao) {
		this.id = id;
		this.atribuicao = atribuicao;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		ambiente = atribuicao.executar(ambiente);
		ambiente.changeValor(id, ambiente.get(atribuicao.getId()));
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return atribuicao.checaTipo(ambiente) && id.getTipo(ambiente).eIgual(atribuicao.getId().getTipo(ambiente));
	}

	@Override
	public Id getId() {
		return atribuicao.getId();
	}

}
