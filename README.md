# ☕ Revisão Prática de Java — Maratona Java (DevDojo)

Este Repositório contem 3 exercícios desenvolvidos pelo Notebook com base nas aulas no youtube Maratona JAVA virado no Jiraya do canal DEVDojo

---

## 📋 Critérios de Avaliação Aplicados

Em todos os exercícios, a resolução é avaliada segundo três pilares:

1. **🎯 Entrega e Funcionalidade**: Validação se o código executa corretamente, atende a todos os requisitos do enunciado e trata casos de borda sem exceções não tratadas.
2. **🧠 Lógica de Programação**: Análise da eficiência da solução, orientação a objetos, reutilização de código e escolha adequada de estruturas de dados.
3. **📐 Convenções do Java**: Verificação das boas práticas da linguagem, como padrões de nomenclatura (*camelCase*, *PascalCase*, *UPPER\_SNAKE\_CASE*), encapsulamento, estrutura de pacotes e legibilidade.

---

## 🏋️ Exercícios Propostos

### 🛒 Exercício 1: Gestão de Estoque e Precificação

* **Módulos do Curso**: Aulas 10 a 83
* **Conceitos Testados**: Tipos Primitivos, Estruturas de Repetição, Arrays/Listas, Orientação a Objetos (Atributos, Métodos, Encapsulamento, Construtores) e `Enum`.

#### 📌 Cenário Prático

Desenvolvimento de um módulo de checkout para um e-commerce que armazena produtos, calcula o valor final de uma compra aplicando descontos baseados na categoria e atualiza o estoque disponível.

#### 📝 Requisitos

1. **Enum** **TipoProduto** **/** **TypeProduct**:
  * Categorias: `ELETRONICO` (10% de desconto), `VESTUARIO` (15% de desconto) e `ALIMENTO` (0% de desconto).
  * O fator/porcentagem de desconto deve ser um atributo do próprio Enum, com método para calcular o valor com desconto.
2. **Classe** **Produto** **/** **Product**:
  * Atributos privados: `nome`, `preco`, `quantidadeEstoque` e `tipoProduto`.
  * Construtor completo e métodos *getters/setters*.
  * Método `darBaixaEstoque(int quantidade)` / `stockReduce(int quantity)` que subtrai a quantidade do estoque se houver saldo suficiente e retorna `true`, ou `false` caso contrário.
3. **Classe de Teste /** **Main**:
  * Criar uma lista com no mínimo 3 produtos diferentes.
  * Simular uma compra em lote, calculando e exibindo no console:
    * O valor original de cada produto e seu valor com desconto.
    * O valor total acumulado do pedido.
    * O estoque atualizado após a baixa.

---

### 💳 Exercício 2: Gateway de Pagamentos com Polimorfismo e Exceção Customizada

* **Módulos do Curso**: Aulas 84 a 105
* **Conceitos Testados**: Classes Abstratas, Polimorfismo, Sobrescrita de Métodos (`@Override`) e Tratamento de Exceções (`try-catch`, `throws`, Exceção Personalizada).

#### 📌 Cenário Prático

Um sistema bancário precisa processar saques em diferentes modalidades de conta corrente e poupança, aplicando taxas e limites de cheque especial, além de tratar tentativas de saque acima do limite com exceções personalizadas.

#### 📝 Requisitos

1. **Exceção Customizada** **SaldoInsuficienteException** **/** **InsuficientBalanceException**:
  * Deve ser uma exceção checada (*checked exception*, estendendo `Exception`).
2. **Classe Abstrata** **ContaBancaria** **/** **BankAccount**:
  * Atributos `protected`: `titular` (`owner`) e `saldo` (`balance`).
  * Método abstrato: `public abstract void sacar(double valor) throws SaldoInsuficienteException`.
3. **Subclasses Concretas**:
  * `ContaCorrente` / `CurrentAccount`: Possui atributo de limite de cheque especial e suporta cobrança de taxas no saque. Permite o saque se `(saldo + limite) &gt;= (valor + taxa)`.
  * `ContaPoupanca` / `SavingsAccount`: Sem taxa nem limite extra. Permite saque apenas se `saldo &gt;= valor`.
4. **Tratamento de Erros**:
  * Se o valor solicitado ultrapassar os limites permitidos, deve lançar a `SaldoInsuficienteException` com uma mensagem descritiva.
5. **Classe de Teste**:
  * Instanciar contas, realizar operações válidas e inválidas, e capturar a exceção no bloco `try-catch`.

---

### 📄 Exercício 3: Processador de Relatório de Vendas

* **Módulos do Curso**: Aulas 108 a 140
* **Conceitos Testados**: `String`, `StringBuilder`, `java.time` (`LocalDate`, `DateTimeFormatter`), `Scanner` / `BufferedReader` e Leitura de Arquivos (`FileReader` com `try-with-resources`).

#### 📌 Cenário Prático

A área financeira precisa processar um arquivo `.txt` com o registro de vendas diárias no formato `DATA;CLIENTE;VALOR` (ex: `2026-10-15;Carlos Silva;350.80`) e gerar um resumo gerencial formatado.

#### 📝 Requisitos

1. **Leitura de Arquivo**:
  * Criar um método que receba o caminho do arquivo `vendas.txt`.
  * Utilizar `FileReader` e `BufferedReader` (ou `Scanner`) dentro de um bloco `try-with-resources`.
2. **Processamento e Parsing de Dados**:
  * Separar os campos de cada linha utilizando `;` (`String.split`).
  * Converter a data ISO (`yyyy-MM-dd`) para `LocalDate` usando `DateTimeFormatter`.
  * Converter o valor para `double`.
3. **Geração do Relatório**:
  * Utilizar `StringBuilder` para construir o relatório final contendo:
    * **Total geral** vendido no dia.
    * **Cliente com maior compra** registrada.
    * Listagem formatada de todas as vendas no padrão `[DD/MM/AAAA] - Cliente: X | Valor: R$ Y`.
4. **Tratamento de Exceções**:
  * Tratar adequadamente falhas de I/O (`IOException`).
