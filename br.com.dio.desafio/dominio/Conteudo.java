public abstract class Conteudo {
    
    protected final double XP_PADRAO = 10.0;
    private String titulo;
    private String descricao;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract double calcularXp();
    
}
