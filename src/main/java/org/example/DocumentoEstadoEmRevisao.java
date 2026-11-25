package org.example;

public class DocumentoEstadoEmRevisao implements DocumentoEstado {

    private DocumentoEstadoEmRevisao() {};
    private static DocumentoEstadoEmRevisao instance = new DocumentoEstadoEmRevisao();
    public static DocumentoEstadoEmRevisao getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Em Revisão";
    }

}
