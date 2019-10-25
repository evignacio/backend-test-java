package br.fcamara.test.infra.exception;

public class EstabelecimentoException extends RuntimeException {
    private Enum type = ExceptionType.ESTABELECIMENTO_EXCEPTION;

    public EstabelecimentoException(String message) {
        super(message);
    }
}
