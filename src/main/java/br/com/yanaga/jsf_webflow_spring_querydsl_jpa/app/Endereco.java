package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Endereco implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Version
    Integer version;

    private String endereco;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk", nullable = false)
    Pessoa pessoa;

    protected Endereco(){
    }

    private Endereco(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public static Endereco newInstance(Pessoa pessoa){
        Preconditions.checkNotNull(pessoa);
        return new Endereco(pessoa);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(obj instanceof Endereco) {
            Endereco other = (Endereco) obj;
            return Objects.equal(other.endereco, this.endereco);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.endereco);
    }

    @Override
    public String toString(){
        return Objects.toStringHelper(this).add("endereco", endereco).toString();
    }

    public Long getId(){
        return id;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
