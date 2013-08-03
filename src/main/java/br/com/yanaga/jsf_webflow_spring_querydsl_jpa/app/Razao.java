package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;

public class Razao implements Serializable{

    private final String value;

    private Razao(String value){
        this.value = value;
    }

    public static Razao newInstance(String value){
        Preconditions.checkArgument(!Strings.isNullOrEmpty(value), "Razão é obrigatória.");
        Preconditions.checkArgument(value.length() > 3, "Razão deve ter mais que 3 caracteres.");
        return new Razao(value);
    }

    @Override
    public String toString(){
        return value;
    }
}
