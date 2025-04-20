package com.clical.client.producers;

import com.clical.client.dto.EmailMessageDTO;
import com.clical.client.model.Agendamento;
import com.clical.client.model.Client;
import com.clical.client.model.Servico;
import com.clical.client.model.enums.EmailTipo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
        try {
            EmailMessageDTO emailMessageDTO = new EmailMessageDTO();

            emailMessageDTO.setClientId(client.getCpfClient());
            emailMessageDTO.setEmailDestinatario(client.getEmail());
            emailMessageDTO.setAssunto("Agendamento serviço "+servico.getNome());
            emailMessageDTO.setDataCriacao(agendamento.getDateTime());
            emailMessageDTO.setTipo(String.valueOf(EmailTipo.CRIACAO_AGENDAMENTO));
            emailMessageDTO.setCorpo("Caro: " + client.getNome() +
                    "\nSeu agendamento foi realizado com sucesso!");

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // opcional, para serializar como string
            String json = mapper.writeValueAsString(emailMessageDTO);

            rabbitTemplate.convertAndSend("", routingKey, json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}