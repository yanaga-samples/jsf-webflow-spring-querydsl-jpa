package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Version
    Integer version;

    private Razao razao;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = Lists.newLinkedList();

    protected Pessoa(){
    }

    public static Pessoa newInstance(){
        return new Pessoa();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(obj instanceof Pessoa) {
            Pessoa other = (Pessoa) obj;
            return Objects.equal(this.razao, other.razao);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.razao);
    }

    @Override
    public String toString(){
        return Objects.toStringHelper(this).add("razao", razao).toString();
    }

    public List<Endereco> getEnderecos(){
        System.out.println("-------->" + enderecos.size());
        return ImmutableList.copyOf(enderecos);
    }

    public void addEndereco(Endereco endereco){
        Preconditions.checkNotNull(endereco, "Endereço nao pode ser nulo.");
        System.out.println("-------> " + !enderecos.contains(endereco));
        if(!enderecos.contains(endereco))
            enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco){
        Preconditions.checkNotNull(endereco, "Endereço nao pode ser nulo.");
        enderecos.remove(endereco);
    }

    public Razao getRazao(){
        return razao;
    }

    public void setRazao(Razao razao){
        this.razao = razao;
    }

    public Long getId(){
        return id;
    }
}
