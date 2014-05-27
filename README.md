**Linguagem vaca**

Eduardo Ogliari   egliari@gmail.com

Guilherme Hermes guilherme.hermes182@gmail.com

**1. Expressões**:

Para toda expressão devem ser mantidos os espaços em branco,
Exemplo:

>[variável] RECEBE [número, variável ou expressão] FIM

Todos os comandos devem ser escritos em letra maiúscula, todo comando deve ser encerrado com FIM.

**3.Tipos primitivos**:

**int** para inteiros
**float** para com representação em ponto flutuante
**string** para cadeias de caracteres

**4. Declaração de variáveis**:

**Sem inicialização**:

>[tipo] [nome_da_variavel] FIM


**Com inicialização**:

>[tipo] [nome_da_variavel] RECEBE [expressão] FIM


**5.Controle de fluxo**:

>SE [condição] ENTAO 
>        [comandos]
>SENAO
>        [comandos]
>FIMSE

ou

>    SE [condição] ENTAO
>        [comandos]
>    FIMSE

6. Laços:
    ENQUANTO [condição] ENTAO
        [comandos]
FIMENQUANTO

7. Operadores aritiméticos e lógicos:


Lógicos:


soma  SOMA
subtração  SUBTRAI
multiplicação  MULTIPLICA
resto da divisão  RESTO
divisão  DIVIDE
Aritméticos


maior (>)  MAIOR
menor (<)  MENOR
comparar ( = )  IGUAL
comparar se diferentes (!=)  DIFERENTE
menor ou igual (<=)  MENORIGUAL
maior ou igual   MENORIGUAL
Atribuição:


atribuição RECEBE

8.Impressão de dados na tela:

Exemplo de impressão:

“ola mundo!”:
MUGIR ola -- mundo! FIM

Nova Linha:

MUGIR VAZIO FIM

Imprimir variável:

MUGIR VAR [nome da variavel] FIM

Caso a impressão contenha palavras reservadas:

MUGIR #FIM FIM

No caso de palavras reservadas é necessário que se ponha o símbolo # antes da palavra.

9. Lista de palavras reservadas:

FIM
RECEBE
SOMA
SUBTRAI
MULTIPLICA
DIVIDE
MUGIR
int
float
string
MAIOR
MENOR
MAIORIGUAL
MENORIGUAL
IGUAL
DIFERENTE
ENQUANTO
FIMENQUANTO
SE
FIMSE
RESTO
SENAO
