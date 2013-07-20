package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class PessoaValidator{

    public boolean validate(Pessoa pessoa,
                            MessageContext messages){
        if(pessoa.getEnderecos().isEmpty())
            messages.addMessage(new MessageBuilder().error().defaultText("É necessário informar um endereço!").build());
        return !messages.hasErrorMessages();
    }
}
