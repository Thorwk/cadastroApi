package restproject.cadastroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.core.service.PessoaService;
import restproject.cadastroapi.request.PessoaRequest;
import restproject.cadastroapi.response.PessoaResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController extends CustomExceptionHandler {

    public static final String BASE_URL = "/pessoas";

    @Autowired
    public PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PessoaResponse> salvarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
       return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPessoa(pessoaRequest));
    }

    // TODO Definir payload a ser retornado para este método, quais atributos?
    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPessoa(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

}
