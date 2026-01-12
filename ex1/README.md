# Exercício 1: Framework de Somatório Genérico

## Arquitetura Clean/Onion Architecture

Este projeto demonstra a implementação de um framework genérico para cálculo de somatórios seguindo os princípios de **Clean Architecture**.

### Estrutura de Camadas

```
ex1/
├── domain/              (Domain Layer - Innermost)
│   ├── MathFunction.java
│   └── SummationService.java
├── application/         (Application Layer - Use Cases)
│   └── SummationServiceImpl.java
└── client/              (Presentation/Infrastructure - Outermost)
    └── ClientExample.java
```

### Princípios Aplicados

#### 1. **Dependency Rule**
- As dependências apontam sempre para dentro (camadas externas dependem das internas)
- Domain não conhece Application ou Client
- Application depende apenas do Domain
- Client depende de Domain e Application

#### 2. **Separation of Concerns**
- **Domain**: Define contratos e regras de negócio (`MathFunction`, `SummationService`)
- **Application**: Implementa casos de uso (`SummationServiceImpl`)
- **Client**: Detalhes de infraestrutura e apresentação (`ClientExample`)

#### 3. **SOLID Principles**
- **Single Responsibility**: Cada classe tem uma única responsabilidade
- **Open/Closed**: Extensível via novas implementações de `MathFunction`
- **Liskov Substitution**: Qualquer implementação de `SummationService` é intercambiável
- **Interface Segregation**: Interfaces coesas e focadas
- **Dependency Inversion**: Dependência em abstrações, não em implementações concretas

### Benefícios desta Arquitetura

1. **Testabilidade**: Fácil criar mocks de `SummationService` para testes
2. **Manutenibilidade**: Mudanças em uma camada não afetam as outras
3. **Extensibilidade**: Novas funções matemáticas podem ser adicionadas sem modificar o framework
4. **Independência de Framework**: O core (domain) não depende de tecnologias específicas
5. **Colaboração em Equipe**: Estrutura clara facilita trabalho paralelo

### Exemplo de Uso

```java
SummationService service = new SummationServiceImpl();
MathFunction function = i -> (int) (4 + Math.sin(i));
int result = service.calculate(1, 10, function);
```

### Relevância para Desenvolvimento Web

Esta arquitetura é diretamente aplicável ao desenvolvimento de SPAs e backend services:
- **Domain Layer**: Entidades de negócio e casos de uso
- **Application Layer**: Serviços e lógica de aplicação
- **Infrastructure**: Controllers REST, repositories, UI components
