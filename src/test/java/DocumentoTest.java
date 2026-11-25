import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

    // salva todos os estados q o doc passou
    @Test
    void deveGuardarHistorico() {
        Documento doc = new Documento();
        doc.setEstado(DocumentoEstadoRascunho.getInstance());
        doc.setEstado(DocumentoEstadoEmRevisao.getInstance());
        doc.setEstado(DocumentoEstadoPublicado.getInstance());
        assertEquals(3, doc.getEstados().size());
    }

    // volta pro primeiro estado
    @Test
    void deveVoltarProRascunho() {
        Documento doc = new Documento();
        doc.setEstado(DocumentoEstadoRascunho.getInstance());
        doc.setEstado(DocumentoEstadoPublicado.getInstance());
        doc.restauraEstado(0);
        assertEquals(DocumentoEstadoRascunho.getInstance(), doc.getEstado());
    }

    // voltou pra revisao no meio do caminho
    @Test
    void deveVoltarPraUmEstadoDoMeio() {
        Documento doc = new Documento();
        doc.setEstado(DocumentoEstadoRascunho.getInstance());
        doc.setEstado(DocumentoEstadoEmRevisao.getInstance());
        doc.setEstado(DocumentoEstadoRascunho.getInstance());
        doc.setEstado(DocumentoEstadoEmRevisao.getInstance());
        doc.setEstado(DocumentoEstadoPublicado.getInstance());
        doc.restauraEstado(3);
        assertEquals(DocumentoEstadoEmRevisao.getInstance(), doc.getEstado());
    }

    // doc sem historico nenhum, nao da pra restaurar
    @Test
    void deveDarErroIndiceInvalido() {
        try {
            Documento doc = new Documento();
            doc.restauraEstado(1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

}
