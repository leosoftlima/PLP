package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.ValorBooleano;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;

public class Ternario implements Comando {

	private Expressao expressao;

	private Comando comandoInterrogacao;

	private Comando comandoDoisPontos;

	public Ternario(Expressao expressao, Comando comandoThen, Comando comandoElse) {
		this.expressao = expressao;
		this.comandoInterrogacao = comandoThen;
		this.comandoDoisPontos = comandoElse;
	}

	/**
	 * Implementa o comando <code>expressao ? comando : comando</code>.
	 * 
	 * @param ambiente o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando
	 *         <code>expressao ? comando : comando</code>.
	 * @throws ErroTipoEntradaException
	 * 
	 */
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		if (((ValorBooleano) expressao.avaliar(ambiente)).valor())
			return comandoInterrogacao.executar(ambiente);
		else
			return comandoDoisPontos.executar(ambiente);
	}

	/**
	 * Realiza a verificacao de tipos da express�o e dos comandos do comando
	 * <code>expressao ? comando : comando</code>
	 * 
	 * @param ambiente o ambiente de compila��o.
	 * @return <code>true</code> se a express�o e os comando s�o bem tipados;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return expressao.checaTipo(ambiente) && expressao.getTipo(ambiente).eBooleano()
				&& comandoInterrogacao.checaTipo(ambiente) && comandoDoisPontos.checaTipo(ambiente);
	}

	@Override
	public Comando corrigir()
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}
}
