package generation.escola.prova.controller;

import generation.escola.prova.domain.model.Aluno;
import generation.escola.prova.service.impl.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        var user = alunoService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno alunoToCreate) {
        var aluno = alunoService.create(alunoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();
        return ResponseEntity.created(location).body(aluno);
    }

    @PutMapping
    public ResponseEntity<Aluno> update(@RequestBody Aluno alunoRequest) {
        return ResponseEntity.ok(alunoService.create(alunoRequest));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        boolean deletou = alunoService.delete(id);
        if (deletou){
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }

}
