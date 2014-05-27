 **Linguagem vaca**
- 

- Eduardo Ogliari   egliari@gmail.com
- Guilherme Hermes guilherme.hermes182@gmail.com


A classe **Read** possui o método main. Portanto, é necessário executar o seguinte comando para iniciar a interpretação:

        java Read [nomedoarquivo].vaca



**1. Expressões**:

Para toda expressão devem ser mantidos os espaços em branco,
Exemplo:

    [variável] RECEBE [número, variável ou expressão] FIM

Todos os comandos devem ser escritos em letra maiúscula, todo comando deve ser encerrado com **FIM**.

**3.Tipos primitivos**:

- **int** para inteiros
- **float** para com representação em ponto flutuante (*Devem ser escritos com ponto decimal*)
- **string** para cadeias de caracteres


**4. Declaração de variáveis**:

**Sem inicialização**:

    [tipo] [nome_da_variavel] FIM


**Com inicialização**:

    [tipo] [nome_da_variavel] RECEBE [expressão] FIM


**5.Controle de fluxo**:

    SE [condição] ENTAO 
       [comandos]
    SENAO
       [comandos]
    FIMSE

ou

    SE [condição] ENTAO
       [comandos]
    FIMSE


**6.Laços**:

    ENQUANTO [condição] ENTAO
        [comandos]
    FIMENQUANTO


**7. Operadores aritiméticos e lógicos**:


**Lógicos**:


- soma (+)  SOMA
- subtração (-)  SUBTRAI
- multiplicação (*)  MULTIPLICA
- resto da divisão (%)  RESTO
- divisão (/)  DIVIDE


**Aritméticos**


- maior (>)  MAIOR
- menor (<)  MENOR
- comparar ( = )  IGUAL
- comparar se diferentes (!=)  DIFERENTE
- menor ou igual (<=)  MENORIGUAL
- maior ou igual (>=)   MENORIGUAL


**Atribuição**:


- atribuição (=) RECEBE


**8.Impressão de dados na tela**:


Para imprimir algo na tela é utilizado o comando **MUGIR**:


“*ola mundo*!”
>MUGIR ola -- mundo! FIM

Aonde dois hífens indicam espaço em branco --

**Nova Linha**:

>MUGIR VAZIO FIM

VAZIO seria o equivalente a "\n" em C

**Imprimir variável**:


>MUGIR VAR [nome da variavel] FIM

O nome da variável a ser impressa deve sempre aparecer após a palavra **VAR**

**Caso a impressão contenha palavras reservadas**:

    MUGIR #FIM FIM

No caso de palavras reservadas é necessário adicionar o símbolo **#** antes da palavra.

É possível mugir através do comando:

>MUGIR FIM


**9. Lista de palavras reservadas**:

- **FIM**
- **RECEBE**
- **SOMA**
- **SUBTRAI**
- **MULTIPLICA**
- **DIVIDE**
- **MUGIR**
- **int**
- **float**
- **string**
- **MAIOR**
- **MENOR**
- **MAIORIGUAL**
- **MENORIGUAL**
- **IGUAL**
- **DIFERENTE**
- **ENQUANTO**
- **FIMENQUANTO**
- **SE**
- **FIMSE**
- **RESTO**
- **SENAO**
