package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class Ternario implements Expressao {

	private Expressao expressao;

	private Expressao expressaoInterrogacao;

	private Expressao expressaoDoisPontos;

	public Ternario(Expressao expressao, Expressao expressaoInterrogacao, Expressao expressaoDoisPontos) {
		this.expressao = expressao;
		this.expressaoInterrogacao = expressaoInterrogacao;
		this.expressaoDoisPontos = expressaoDoisPontos;
	}

	/**
	 * Implementa a expressao <code>expressao ? expressao : expressao</code>.
	 * 
	 * @param ambiente o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do expressao
	 *         <code>expressao ? expressao : expressao</code>.
	 * @throws VariavelNaoDeclaradaException
	 * 
	 */

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		if (((ValorBooleano) expressao.avaliar(amb)).valor())
			return expressaoInterrogacao.avaliar(amb);
		else
			return expressaoDoisPontos.avaliar(amb);
	}

	/**
	 * Realiza a verificacao de tipos da express�o e dos expressao do expressao
	 * <code>expressao ? expressao : expressao</code>
	 * 
	 * @param ambiente o ambiente de compila��o.
	 * @return <code>true</code> se a express�o e os expressao s�o bem tipados;
	 *         <code>false</code> caso contrario.
	 */

	@Override
	public boolean checaTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressao.checaTipo(amb) && expressao.getTipo(amb).eBooleano() && expressaoInterrogacao.checaTipo(amb)
				&& expressaoDoisPontos.checaTipo(amb);
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressao.getTipo(amb);
	}

	@Override
	public Expressao reduzir(AmbienteExecucao ambiente) {
		this.expressao = expressao.reduzir(ambiente);
		this.expressaoInterrogacao = expressaoInterrogacao.reduzir(ambiente);
		this.expressaoDoisPontos = expressaoDoisPontos.reduzir(ambiente);

		return this;
	}

	@Override
	public Expressao clone() {
		return new Ternario(expressao.clone(), expressaoInterrogacao.clone(), expressaoDoisPontos.clone());
	}

	public Expressao getExpressaoInterrogacao() {
		return expressaoInterrogacao;
	}

	public Expressao getExpressaoDoisPontos() {
		return expressaoDoisPontos;
	}
	public Expressao getExpressao() {
		return expressao;
	}
}
