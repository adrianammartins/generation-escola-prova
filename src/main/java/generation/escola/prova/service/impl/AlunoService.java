package generation.escola.prova.service.impl;

import generation.escola.prova.domain.model.Aluno;
import generation.escola.prova.domain.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Aluno create(Aluno alunoToCreate) {
        if (alunoRepository.existsByNome(alunoToCreate.getNome())) {
            throw new IllegalArgumentException("This Aluno already exists.");
        }
        return alunoRepository.save(alunoToCreate);
    }

    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public boolean delete(Long idAluno) {
        Optional<Aluno> alunoBanco = alunoRepository.findById(idAluno);
        if (alunoBanco.isPresent()){
            alunoRepository.delete(alunoBanco.get());
            return true;
        }
        return false;
    }
}
