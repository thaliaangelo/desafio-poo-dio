import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosFinalizados = new LinkedHashSet<>();

    //Ele pega o bootcamp e adiciona no set de conteudosInscritos, assim, o dev terá acesso a todos os conteudos que existe do bootcamp
    public void entrarBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    //Ele verifica se o conteudo ainda está presente no set, assim, quando esse metodo for chamado ele adiciona o primeiro conteudo do set de conteudoInscritos
    // no set de conteudosConcluidos, e remove do set de conteudosInscritos, pois significa que ele ja concluiu aquele conteudo
    public void progredir() {
        Optional <Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosFinalizados.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está em nenhum conteudo!! ");
        }
    }

    //Calcula o total de xp de acordo com os cursos e mentorias finalizados
    public double calcularTotalXp() {
        return this.conteudosFinalizados.stream()
        .mapToDouble(conteudo -> conteudo.calcularXp())
        .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosFinalizados() {
        return conteudosFinalizados;
    }

    public void setConteudosFinalizados(Set<Conteudo> conteudosFinalizados) {
        this.conteudosFinalizados = conteudosFinalizados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
        result = prime * result + ((conteudosFinalizados == null) ? 0 : conteudosFinalizados.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (conteudosInscritos == null) {
            if (other.conteudosInscritos != null)
                return false;
        } else if (!conteudosInscritos.equals(other.conteudosInscritos))
            return false;
        if (conteudosFinalizados == null) {
            if (other.conteudosFinalizados != null)
                return false;
        } else if (!conteudosFinalizados.equals(other.conteudosFinalizados))
            return false;
        return true;
    }

    
}
