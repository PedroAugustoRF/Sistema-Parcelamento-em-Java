# 💰 Sistema de Parcelamento de Contratos

## 📌 Sobre o Projeto

Este projeto é um sistema simples de **parcelamento de contratos**, desenvolvido em Java, com foco em aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** e boas práticas de arquitetura.

O sistema recebe os dados de um contrato e calcula automaticamente suas parcelas, considerando **juros e taxas de pagamento online**.

---

## 🚀 Funcionalidades

* Cadastro de contrato (número, data e valor total)
* Definição da quantidade de parcelas
* Cálculo automático de:

  * Juros mensais
  * Taxa de pagamento
* Geração das parcelas com data e valor formatado

---

## 🧠 Conceitos Aplicados (FOCO PARA ESTUDO)

### 🔹 1. Programação Orientada a Objetos (POO)

#### ✔️ Encapsulamento

As classes como `Contrato` e `Parcela` encapsulam seus dados com atributos privados e métodos públicos (getters/setters).

```java
private Double valorTotal;

public Double getValorTotal() {
    return valorTotal;
}
```

---

#### ✔️ Abstração

A interface `ServicoPagamentoOnline` define um **contrato** que qualquer serviço de pagamento deve seguir:

```java
public interface ServicoPagamentoOnline {
    Double taxaPagamento(Double quantia);
    Double juros(Double quantia, Integer meses);
}
```

👉 Aqui você aprende a separar **"o que fazer"** de **"como fazer"**.

---

#### ✔️ Polimorfismo

A classe `ServicoPaypal` implementa a interface:

```java
public class ServicoPaypal implements ServicoPagamentoOnline
```

Isso permite trocar facilmente o serviço de pagamento no futuro (ex: Stripe, PagSeguro).

---

#### ✔️ Injeção de Dependência (Dependency Injection)

No `ServicoContrato`, o serviço de pagamento é injetado via construtor:

```java
public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
    this.servicoPagamentoOnline = servicoPagamentoOnline;
}
```

👉 Isso desacopla o código e facilita manutenção e testes.

---

### 🔹 2. Padrão Strategy (Estratégia)

O projeto utiliza o padrão **Strategy**, onde diferentes regras de pagamento podem ser aplicadas sem alterar o código principal.

✔️ Interface: estratégia
✔️ Implementação: PayPal

💡 Você pode criar outro serviço (ex: `ServicoStripe`) sem mexer no resto do sistema.

---

### 🔹 3. Manipulação de Datas (Java Time API)

Uso da classe `LocalDate` para trabalhar com datas:

```java
LocalDate dataVencimento = contrato.getData().plusMonths(i);
```

👉 Aprende:

* Soma de meses
* Formatação de datas (`DateTimeFormatter`)

---

### 🔹 4. Listas (Collections)

O contrato possui uma lista de parcelas:

```java
private List<Parcela> parcelas = new ArrayList<>();
```

👉 Conceitos importantes:

* Estrutura dinâmica
* Iteração com `for-each`

---

### 🔹 5. Lógica de Negócio

O cálculo das parcelas acontece aqui:

```java
double parcelaBase = contrato.getValorTotal() / meses;

double juros = servicoPagamentoOnline.juros(parcelaBase, i);
double taxaPagamento = servicoPagamentoOnline.taxaPagamento(parcelaBase + juros);

double parcela = parcelaBase + juros + taxaPagamento;
```

📌 Regras aplicadas:

* Juros: 1% ao mês (multiplicado pelo número da parcela)
* Taxa: 2% sobre o valor com juros

---

## 🏗️ Estrutura do Projeto

```
sistemaParcelamento/
│
├── application/
│   └── App.java
│
├── model/
│   ├── entities/
│   │   ├── Contrato.java
│   │   └── Parcela.java
│   │
│   └── services/
│       ├── ServicoContrato.java
│       ├── ServicoPagamentoOnline.java
│       └── ServicoPaypal.java
```

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Compile e execute o projeto Java

3. Insira os dados no terminal:

```
Número do contrato
Data
Valor total
Quantidade de parcelas
```

---

## 📊 Exemplo de Saída

```
Parcelas:
01/04/2026 - 102.00
01/05/2026 - 104.04
01/06/2026 - 106.12
```

---

## 💡 Possíveis Melhorias (Para Evoluir o Projeto)

* Criar novos serviços de pagamento (Stripe, Mercado Pago)
* Implementar tratamento de exceções
* Criar interface gráfica (JavaFX ou Swing)
* Persistência em banco de dados
* Aplicar padrão MVC completo

---

## 🎯 Conclusão

Este projeto é excelente para praticar:

* POO na prática
* Interfaces e Polimorfismo
* Injeção de dependência
* Boas práticas de arquitetura
* Separação de responsabilidades

---

## 👨‍💻 Autor

Desenvolvido por Pedro Augusto 🚀
