public class Eleitor{
    
    public int tituloEleitoral;
    public String nomeEleitor;
    public int zonaEleitoral;
    public int secaoEleitoral;
    public boolean present;

    public int getTitulo() {
		return tituloEleitoral;
	}
	public void setTitulo(int titulo) {
		this.tituloEleitoral = titulo;
	}
	public String getNome() {
		return nomeEleitor;
	}
	public void setNome(String nome) {
		this.nomeEleitor = nome;
	}
    public int getZona() {
		return zonaEleitoral;
	}
	public void setZona(int zona) {
		this.zonaEleitoral = zona;
	}
    public int getSecao() {
		return secaoEleitoral;
	}
	public void setSecao(int secao) {
		this.secaoEleitoral = secao;
	}
}

