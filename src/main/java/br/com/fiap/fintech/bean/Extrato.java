package br.com.fiap.fintech.bean;

import java.util.List;

public class Extrato {
  public List<Despesa> despesas;
  public List<Deposito> depositos;
  public Despesa despesa;
  public Deposito deposito;

  public Extrato() {
    super();
  }

  public Extrato(List<Despesa> despesas, List<Deposito> depositos) {
    this.despesas = despesas;
    this.depositos = depositos;
  }

  public void setDespesas(Despesa despesa)
  {
    this.despesas.add(despesa);
  }

  public List<Despesa> getDespesa()
  {
    return this.despesas;
  }

  public void setDepositos(Deposito deposito)
  {
    this.depositos.add(deposito);
  }

  public List<Despesa> getDespesas()
  {
    return this.despesas;
  }
}
