package li2.plp.imperative2.util;

public class Logger {
	
	private final static Logger instance = new Logger();
	
	private StringBuilder mensagem = new StringBuilder();
	  
    private Logger() {}

    public static Logger getInstance() {
              return instance;
    }

	public StringBuilder append(String str) {
		return mensagem.append(str);
	}
	
	public StringBuilder getMensagem() {
		return mensagem;
	}
	public void limparMensagem() {
		this.mensagem.setLength(0);  ;
	}
	
}
