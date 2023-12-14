package com.guimartins.produtoapi.exception;

public class RegNaoEncontradoException extends RuntimeException {
    public RegNaoEncontradoException(Long id){
        super("Registro não encontrado com o ID: " + id);
    }
}
