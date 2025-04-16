package com.clical.client.producers;

import com.clical.client.dto.EmailMessageDTO;
import com.clical.client.model.Agendamento;
import com.clical.client.model.Client;
import com.clical.client.model.Servico;
import com.clical.client.model.enums.EmailTipo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class AgendamentoProducer {

    final RabbitTemplate rabbitTemplate;

    public AgendamentoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMassegeEmail(Agendamento agendamento,Client client, Servico servico) {
        var emailMessageDTO = new EmailMessageDTO();
        emailMessageDTO.setEmailDestinatario(client.getEmail());
        emailMessageDTO.setAssunto(servico.getNome());
        emailMessageDTO.setDataCriacao(agendamento.getDateTime());
        emailMessageDTO.setTipo(String.valueOf(EmailTipo.CRIACAO_AGENDAMENTO));
        emailMessageDTO.setCorpo(client.getNome());

        rabbitTemplate.convertAndSend("",routingKey,emailMessageDTO);
    }
}