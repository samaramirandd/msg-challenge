# Exercise 2: Messaging App

## Clean Architecture + Strategy Pattern

This project implements the "Post Message" use case using **Clean Architecture** and the **Strategy** pattern.

### Layered Structure

```
ex2/
├── domain/                          (Domain Layer - innermost)
│   ├── User.java                    (Entity)
│   ├── Message.java                 (Entity)
│   ├── Credentials.java             (Value Object)
│   ├── SocialMediaService.java      (Enum)
│   ├── MessagePostingStrategy.java  (Interface - Strategy)
│   └── PostingException.java        (Domain Exception)
│
├── application/                     (Application Layer - Use Cases)
│   ├── PostMessageUseCase.java      (Orchestrator)
│   └── MessageStrategyFactory.java  (Factory)
│
├── infrastructure/                  (Infrastructure Layer)
│   └── strategy/
│       ├── TwitterStrategy.java     (Concrete Strategy)
│       └── FacebookStrategy.java    (Concrete Strategy)
│
└── presentation/                    (Presentation Layer - outermost)
    └── MessagingClient.java         (UI/Entry Point)
```

### UML Diagrams

> PNGs only render after generating them from the PUML sources below.
> Generate locally with:
> `plantuml ex2/diagrams/class-diagram.puml`
> `plantuml ex2/diagrams/sequence-post-message.puml`

1) **Class Diagram**

 ![Class Diagram](ex2/diagrams/class-diagram.svg)

1) **Sequence Diagram — Use Case "Post Message"**

 ![Sequence Diagram](ex2/diagrams/sequence-post-message.svg)

## Implemented Principles

### Clean Architecture Layers
- ✅ Domain: Entities, Value Objects, Interfaces (business rules)
- ✅ Application: Use Cases, Factories (orchestration)
- ✅ Infrastructure: Concrete strategy implementations
- ✅ Presentation: Client/UI (outer layer)

### Strategy Pattern
- ✅ Interface `MessagePostingStrategy` defines the contract
- ✅ `TwitterStrategy` and `FacebookStrategy` implement different behaviors
- ✅ Runtime selection via factory

### SOLID Principles
- Single Responsibility: One responsibility per class
- Open/Closed: Extend for new services without modifying existing code
- Liskov Substitution: Any strategy is interchangeable
- Interface Segregation: Focused, cohesive interfaces
- Dependency Inversion: Depend on abstractions

### Explicit Use Cases
- `PostMessageUseCase` implements the use-case logic
- Centralized business validations
- Domain-specific error handling

## Execution Flow

```
1. User writes message and chooses platform
2. MessagingClient calls PostMessageUseCase.execute()
3. PostMessageUseCase validates input (business rules)
4. MessageStrategyFactory creates the appropriate strategy
5. Strategy authenticates with the target service
6. Strategy formats and posts the message
7. Confirmation returns to the user
```

## Testability

The architecture enables testing at different levels:

```java
// Unit test - mock the strategy
MessagePostingStrategy mockStrategy = mock(MessagePostingStrategy.class);
PostMessageUseCase useCase = new PostMessageUseCase(new MockFactory(mockStrategy));
// ... assertions

// Integration test
PostMessageUseCase useCase = new PostMessageUseCase(new MessageStrategyFactory());
useCase.execute(user, message, SocialMediaService.TWITTER, creds);
```

## Extensibility

To add a new service (e.g., Instagram):

```java
// 1. Add to enum
public enum SocialMediaService { TWITTER, FACEBOOK, INSTAGRAM; }

// 2. Create strategy
public class InstagramStrategy implements MessagePostingStrategy { ... }

// 3. Add to factory
case INSTAGRAM -> new InstagramStrategy();

// No changes in PostMessageUseCase!
```

## Running

```bash
javac -d . ex2/**/*.java
java ex2.presentation.MessagingClient
```

## Relevance for the Internship

This implementation demonstrates:
- ✅ Mastery of layered Clean Architecture
- ✅ Design patterns (Strategy + Factory)
- ✅ Domain modeling (Entities, Value Objects)
- ✅ Domain-specific error handling
- ✅ Extensibility and maintainability
- ✅ Scalable structure for multiple services (like a SPA with multiple features)
