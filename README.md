## Sistema De Prefeitura

Gotham City nos procurou para desenvolver um MVP do seu sistema de gestão.<br/>
Dado o desafio, optaremos por uma arquitetura em que teremos uma API como <br/>
back-end para que futuramente o sistema seja utilizado por vários clientes de front.

## Domínios e Fluxos:

#### Cadastro de Secretarias
#### Cadastro de Funcionários
#### Cadastro de Projetos

## CRUD - EndPoints

## Secretárias:

- Criação;
- Consulta;
- Alteração;
- Remoção;
- Listagem;

## Funcionários:

- Criação;
- Consulta;
- Alteração;
- Remoção;
- Listagem;

## Projetos:

- Criação;
- Consulta;
- Alteração;
- Listagem;

## Modelagem:
- [X] Diagrama de Classes

## Organização: 
- [x] TRELLO

## Pacotes:

- Controller
- DTO
- Entity
- Enums
- Repository
- Service

## Classes:

#### Repository
- FuncionarioRepository;
- ProjetoRepository;
- SecretariaRepository;

#### Controller
- FuncionarioController;
- ProjetoController;
- SecretariaController;

#### DTO
- FuncionarioDTO;
- MensagemDTO;
- ProjetoDTO;
- SecretariaDTO;

#### Entity
- FuncionarioEntity;
- ProjetoEentity;
- SecretariaEntity;

#### Enum
- AreaEnums;

#### Service
- FuncionarioService;
- ProjetoService;
- SecretariaService;
- IFuncionarioService;
- IProjetoService;
- ISecretariaService;
