Sistema de Controle de Voos - API
=================================

_Projeto desenvolvido como teste para vaga Java na empresa Atech Negócios em Tecnologias S/A_

O Sistema de Controle de Voos foi desenvolvido para armazenamento, busca e detalhamento de voos de uma empresa disponíveis dado um período escolhido pelo usuário.


**Requerimentos para Execução:**

JDK 1.8 - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Apache Maven 3.0.5+ - https://maven.apache.org/download.cgi

Docker - https://docs.docker.com/engine/installation/


**Execução:**

Para subir um container docker do MySql, entrar no diretório da aplicação e executar `$ docker-compose up`.

Para iniciar aplicação, entrar no diretório da aplicação e executar  `$ mvn clean spring-boot:run`.

Será executado em **localhost** porta **8080**.


API para consulta dos dados relacionados ao Voo
-------------------

GET   /voos

GET   /voos/{id}

GET  /pilotos

GET  /pilotos/{id}

GET  /aeroportos

GET  /aeroportos/{id}

**Exemplos de Retornos JSON**

Piloto JSON:

    {
      id: 1,
      nome: "Wesley Barbosa",
      documento: "158785489",
      cma: "MG-PA-568974666",
      horasDeVoo: 560
    }

Aeroporto JSON:

    {
      id: 1,
      iata: "BSB",
      icao: "SBBR",
      nome: "Aer. Pr Jucelino Kubitschek",
      cidade: "Brasília",
      uf: "DF",
      pais: "Brasil",
      utc: -5,
      latitude: -15.6661,
      longitude: 48.006
    }

Voo JSON:

    {
      id: 1,
      partida: {...}, 
      chegada: {...}, 
      piloto: {...}, 
      aviao: {...}, 
      Origem: {...}, 
      destino: {...}, 
      status: "AGENDADO",
      horarioDeChegadaLocal: "04/03/2017 21:57:51",
      horarioDePartidaLocal: "04/03/2017 13:57:51",
      horarioDeChegadaUTC: "04/03/2017 18:57:51",
      horarioDePartidaUTC: "04/03/2017 18:57:51"
    }
