package br.fcamara.test.infra.exception;

import br.fcamara.test.infra.exception.ExceptionType;

public class UncategorizedException extends RuntimeException {
    private Enum type = ExceptionType.UNCATEGORIZED_EXCEPTION;

    public UncategorizedException(String message) {
            super(message);
    }
}