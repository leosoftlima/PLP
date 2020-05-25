package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.ExpSoma;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.ValorInteiro;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.util.Logger;

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
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return false;
	}


	@Override
	public Comando corrigir() {
		Logger.getInstance().append("Atom - > " + id.toString() + " := ++" + expressao.toString() + " trocado por - >" + 
													id.toString() + " := " + expressao.toString() + "; " + expressao.toString() + ":= " + expressao.toString() +" + 1" );
		return new SequenciaComando(new AtribuicaoSimples(id, new ExpSoma(expressao, new ValorInteiro(1))), 
				                    new AtribuicaoSimples(new Id(getExpressao().toString()), new ExpSoma(expressao, new ValorInteiro(1)))).corrigir();
		
	}

	@Override
	public Expressao getExpressao() {
		return this.expressao;
	}
	
}
