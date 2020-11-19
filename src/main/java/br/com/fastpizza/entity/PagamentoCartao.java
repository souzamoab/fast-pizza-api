package br.com.fastpizza.entity;

import br.com.fastpizza.enums.EstadoPagamento;
import br.com.fastpizza.enums.TipoCartao;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer tipoCartao;

    public PagamentoCartao() {

    }

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, TipoCartao tipoCartao) {
        super(id, estado, pedido);
        this.tipoCartao = tipoCartao.getCodigo();
    }

    public TipoCartao getTipoCartao() {
        return TipoCartao.toEnum(tipoCartao);
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao.getCodigo();
    }
}
