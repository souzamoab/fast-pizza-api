package br.com.fastpizza.enums;

public enum TipoCartao {

    DEBITO(1, "Débito"),
    CREDITO(2, "Crédito");

    private int codigo;
    private String descricao;

    private TipoCartao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCartao toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }

        for(TipoCartao x : TipoCartao.values()) {
            if(codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido!");
    }

}
