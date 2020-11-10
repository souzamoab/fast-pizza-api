package br.com.fastpizza.enums;

public enum TipoClienteEnum {
    PESSOAFISICA(1, "Pessoa Física");

    private int codigo;
    private String descricao;

    private TipoClienteEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoClienteEnum toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }

        for(TipoClienteEnum x : TipoClienteEnum.values()) {
            if(codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido!");
    }
}
