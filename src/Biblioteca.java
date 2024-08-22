import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    public List<Livro> listarLivros() {
        return this.livros;
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for(Livro livro : livros) {
            if(livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscarLivroPorId(int id) {
        for(Livro livro : livros) {
            if(livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void atualizarTitulo(int id, String titulo) {
        for(Livro livro : livros) {
            if(livro.getId() == id) {
                livro.setTitulo(titulo);
                System.out.println("Livro adicionado com sucesso.");
                break;
            }
        }
    }

    public void excluirLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public void atualizarAutor(int id, String novoNome) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autor.setNomeAutor(novoNome);
                break;
            }
        }
    }

    public void removerAutor(int id) {
        autores.removeIf(autor -> autor.getId() == id);
    }

    public void emprestarLivro(Livro livro, String nomeUsuario) {
        if(livro.isDisponivel()) {
            Emprestimo novoEmprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(novoEmprestimo);
            livro.setDisponivel(false);
            System.out.println("Empréstimo realizado.");
            return;
        }
        System.out.println("Livro indisponível.");
    }

    public void devolverLivro(int id) {
        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getId() == id) {
                emprestimo.devolverLivro();
                System.out.println("Devolução realizada com sucesso.");
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }
}
