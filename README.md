# fit-journey


# Sistema de Gerenciamento de Dietas e Treinos

Este projeto é uma aplicação em Java utilizando Spring Boot para gerenciar dietas, treinos e métricas de usuários. Ele foi projetado para ser utilizado por professores e alunos, permitindo que professores organizem planos de treino e dieta para seus alunos, enquanto os alunos podem registrar métricas corporais e acompanhar seu progresso.

## Objetivos

- Gerenciar usuários com diferentes perfis: **Professores** e **Alunos**.
- Permitir que professores criem e atribuam dietas e treinos personalizados para seus alunos.
- Permitir que alunos acompanhem suas métricas corporais, como peso, altura e percentual de gordura.
- Fornecer uma interface RESTful para interagir com o sistema.

---

## Funcionalidades

### Usuários
- **Professores**:
  - Criam e gerenciam dietas e treinos.
  - Atribuem planos de treino e dieta a seus alunos.
- **Alunos**:
  - Registram métricas corporais.
  - Visualizam seus treinos e dietas.
  - Acompanham o histórico de métricas.

### Dietas
- Cada dieta contém:
  - Nome.
  - Tipo: **Bulking**, **Cutting** ou **Manutenção**.
  - Lista de refeições, cada uma contendo nutrientes específicos.

### Treinos
- Cada treino contém:
  - Nome.
  - Lista de exercícios com repetições e carga.

### Métricas
- Os alunos podem registrar dados como:
  - Peso.
  - Altura.
  - Percentual de gordura.
  - Data do registro.

---


