package br.fcamara.test.infra.exception;

import br.fcamara.test.infra.exception.ExceptionType;

public class VeiculoException extends RuntimeException{
    private Enum type = ExceptionType.VEICULO_EXCEPTION;

    public VeiculoException(String message) {
        super(message);
    }
}
