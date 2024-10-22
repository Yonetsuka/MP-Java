package br.com.fiap.mp.model.entity;

import br.com.fiap.mp.model.dto.RequisicaoNovoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name="Pedido")
@Table(name="pedido")
public class Pedido{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigoProduto;
  private String nomeProduto;
  private BigDecimal valorNegociado;
  private LocalDate dataDaEntrega;
  private String urlProduto;
  private String urlImagem;
  private String descricao;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

    //criar getter e setters
  // Getters
    public Long getCodigoProduto(){
      return codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }
    public StatusPedido getStatus() {
        return status;
    }



    // Setters
    public void setCodigoProduto(Long codigoProduto){
      this.codigoProduto = codigoProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Pedido(){

    }
    public Pedido(RequisicaoNovoPedido requisicao){
        this.nomeProduto = requisicao.nomeProduto();
        this.urlProduto = requisicao.urlProduto();
        this.urlImagem = requisicao.urlImagem();
        this.descricao = requisicao.descricao();
        this.status = StatusPedido.AGUARDANDO;
    }
}
