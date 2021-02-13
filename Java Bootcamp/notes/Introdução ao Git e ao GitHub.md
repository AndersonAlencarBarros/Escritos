---
attachments: [Clipboard_2021-02-08-15-23-29.png, Clipboard_2021-02-08-15-27-56.png, Clipboard_2021-02-08-15-47-51.png, Clipboard_2021-02-08-16-11-23.png]
tags: [java bootcamp]
title: Introdução ao Git e ao GitHub
created: '2021-02-07T20:31:34.229Z'
modified: '2021-02-09T17:38:08.793Z'
---

# Introdução ao Git e ao GitHub

## Funcionamento

- **SHA1:** significa *Secure Hash Algorithm*, é um conjunto de funções hash criptográficas projetadas pela NSA que gera um conjunto de caracteres de 40 dígitos. É uma forma curta de representar um arquivo.

- **Objetos fundamentais:** 
  - Blobs são objetos do Git que os arquivos e metadados: o tipo do objeto, o tamanho do arquivo, um \0 e o conteúdo do arquivo. Por isso que o SHA gerado dentro do Git e fora são diferentes.

  - Trees armazeram blobs e apontam para tipos de blobs diferentes e até outras Trees, além de guardar o nome do arquivo. As Trees são responsáveis por monta toda a estrutura onde se encontra os arquivos. As Trees também tem um SHA1 dos metadados das árvores.

![](@attachment/Clipboard_2021-02-08-15-23-29.png)

  - Commits aponta para uma árvore, um parente (último commit realizado antes dele), autor, mensagem, timestamp.

![](@attachment/Clipboard_2021-02-08-15-27-56.png)
 
## Criando um Commit

- `git init` inicializa um repositório git
- `git add *` 
- `git commit -m <texto>` cria um commit

### Ciclo de vida de um arquivo no Git

![](@attachment/Clipboard_2021-02-08-15-47-51.png)

- **Untracked:** quando o Git ainda não sabe do arquivo.
- **Tracked:** após o `git add *`, o arquivo vai para **Staged**, onde fica na espera por algo. 
- **Staged** é a preparação para um commit, que após feito, é considerado um **Unmodified**, pois o commit faz um "snapshot" daquele arquivo.

![](@attachment/Clipboard_2021-02-08-16-11-23.png)

O **Repositório Local** é apenas composto por commits, logo após o **Staged**, por isso, tudo deve estar "commitado" para enviar para um repositório remoto.

## Comandos

- `git status` vai mostrar o estado dos arquivos, para mostrar quais arquivos estão untracked, unmodified, modified, staged.

- `git config --global --unset user.email` remove o email
- `git config --global --unset user.name` remove o nome do autor

- `git config --global user.email "<email>"` configura o email do autor
- `git config --global user.name "<nome>"` configura o nome do autor
- `git remote add <link do repositório>` adiciona um repositório remoto (o link do repositório remoto é chamado de _origin_)
- `git push origin main` envia o código para o repositório remoto

## Resolvendo conflitos

**Conflito de merge:** ocorre quando há alterações na mesma linha. Dessa forma, é preciso atualizar o repositório local com o remoto e juntar ambos os trabalhos manualmente.

- `git pull` atualiza o repositório remoto com o local, avisa se ocorrer conflitos, com um texto indicativo

A alteração mais atual feita localmente é representada por **=======**, assim pode ser feita uma alteração manual.
 


