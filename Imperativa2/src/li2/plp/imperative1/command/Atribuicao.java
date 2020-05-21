package li2.plp.imperative1.command;

import li2.plp.expressions2.expression.Expressao;

public interface Atribuicao extends Comando {
	Expressao getExpressao();
}
