package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;
import org.w3c.dom.Text;

import java.util.List;

public class ClassroomCollection {

    @Id
    private String id;
    private String alunoId;
    private String cursoId;
    private String moduloId;
    private List<String> prime;
    private List<String> target;
    private List<String> frase;
    private List<String> urlAudio;
    private List<String> urlImagem;
    private List<String> urlVideo;
    private Text text;

}
