
# Backend Job Management

Sistema de gerenciamento de jobs desenvolvido em Java com Spring Boot 3, oferecendo uma API RESTful para controle e monitoramento de jobs com métricas em tempo real via Micrometer e Prometheus.

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Tecnologias e Dependências](#tecnologias-e-dependências)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Configuração e Execução](#configuração-e-execução)
- [Endpoints da API](#endpoints-da-api)
- [Monitoramento com Grafana](#monitoramento-com-grafana)
- [Testes](#testes)

## 🚀 Visão Geral

O Backend Job Management é uma aplicação Spring Boot 3 que fornece endpoints REST com autenticação para criar, gerenciar e monitorar jobs. A aplicação inclui métricas customizadas, health checks e documentação interativa via Swagger/OpenAPI.

## 🛠 Tecnologias e Dependências

### Principais Dependências
- **Spring Boot 3.2.3**
- **Java 17**
- **Spring Data JPA** - Persistência de dados
- **Spring Security - para Auth JWT
- **H2 Database** - Banco em memória para desenvolvimento
- **Springdoc OpenAPI** - Documentação da API
- **Micrometer & Prometheus** - Métricas e monitoramento
- **Spring Boot Actuator** - Health checks e métricas
- **Lombok** - Redução de boilerplate code
- **ModelMapper** - Mapeamento entre DTOs e entidades

### Dependências de Teste
- JUnit 5
- Spring Boot Test
- Mockito

## 💡 Funcionalidades

### Gestão de Jobs
- ✅ Criar, listar, atualizar e excluir jobs
- ✅ Ativar/desativar jobs
- ✅ Buscar jobs por ID
- ✅ Validação de dados de entrada

### Monitoramento e Métricas
- ✅ Health checks via Spring Boot Actuator
- ✅ Métricas customizadas para tracking de jobs
- ✅ Integração com Prometheus
- ✅ Endpoints de métricas expostos

### Documentação
- ✅ Swagger UI para teste interativo da API
- ✅ Documentação OpenAPI 3.0

## 🚀 Configuração e Execução

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

### Executando a Aplicação

1. **Clone o repositório:**
```bash
git clone https://github.com/henriqueaguiiar/backend-job-management.git
cd backend-job-management
```

2. **Compile o projeto:**
```bash
mvn clean compile
```

3. **Execute a aplicação:**
```bash
mvn spring-boot:run
```

4. **Acesse a aplicação:**
   - **API**: http://localhost:8080
   - **Swagger UI**: http://localhost:8080/swagger-ui.html
   - **Actuator Health**: http://localhost:8080/actuator/health
   - **Prometheus Metrics**: http://localhost:8080/actuator/prometheus

### Configurações

O arquivo `application.yml` contém as principais configurações:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: 
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
    show-sql: true
  h2:
    console:
      enabled: true

management:
  endpoints:
    web:
      exposure:
        include: health,metrics,prometheus
  endpoint:
    health:
      show-details: always
```

## 📡 Endpoints da API

### Jobs Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/jobs` | Lista todos os jobs |
| `GET` | `/api/jobs/{id}` | Busca job por ID |
| `POST` | `/api/jobs` | Cria um novo job |
| `PUT` | `/api/jobs/{id}` | Atualiza um job existente |
| `DELETE` | `/api/jobs/{id}` | Exclui um job |
| `PATCH` | `/api/jobs/{id}/activate` | Ativa um job |
| `PATCH` | `/api/jobs/{id}/deactivate` | Desativa um job |

### Actuator Endpoints

| Endpoint | Descrição |
|----------|-----------|
| `/actuator/health` | Status de saúde da aplicação |
| `/actuator/metrics` | Métricas da aplicação |
| `/actuator/prometheus` | Métricas no formato Prometheus |

## 📊 Monitoramento com Grafana

### Configurando Prometheus

1. **Instale o Prometheus** (usando Docker):
```bash
docker run -d -p 9090:9090 \
  -v /path/to/prometheus.yml:/etc/prometheus/prometheus.yml \
  prom/prometheus
```

2. **Configure o `prometheus.yml`:**
```yaml
global:
  scrape_interval: 15s

scrape_configs:
  - job_name: 'job-management'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8080']
```

### Executando Grafana

1. **Execute o Grafana com Docker:**
```bash
docker run -d -p 3000:3000 grafana/grafana
```

2. **Acesse o Grafana:**
   - URL: http://localhost:3000
   - Login: admin/admin (primeiro acesso)

3. **Configure a fonte de dados:**
   - Vá em **Configuration > Data Sources**
   - Adicione **Prometheus**
   - URL: `http://localhost:9090`

4. **Importe dashboards ou crie seus próprios painéis** para monitorar:
   - Número total de jobs
   - Status dos jobs (ativos/inativos)
   - Métricas de performance da aplicação
   - Health checks

### Métricas Customizadas Disponíveis

- `job_management_jobs_total` - Total de jobs no sistema
- `job_management_jobs_active` - Jobs ativos
- `job_management_jobs_inactive` - Jobs inativos

## 🧪 Testes

### Executando Testes Unitários

```bash
mvn test
```

### Testando a API via Swagger

1. Acesse http://localhost:8080/swagger-ui.html
2. Expanda os endpoints desejados
3. Use o botão "Try it out" para testar as operações

### Exemplo de Criação de Job

```json
{
  "name": "Daily Report Job",
  "description": "Generate daily sales reports",
  "schedule": "0 0 9 * * *",
  "active": true
}
```

## 🔧 Desenvolvimento

### Compilando para Produção

```bash
mvn clean package -DskipTests
```

### Executando o JAR

```bash
java -jar target/backend-job-management-1.0.0.jar
```

## 📝 Notas de Desenvolvimento

- A aplicação utiliza H2 em memória para facilitar desenvolvimento e testes
- As métricas são expostas no formato Prometheus para fácil integração
- Todas as operações de CRUD incluem validações adequadas
- A documentação Swagger é gerada automaticamente a partir dos controladores

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---
