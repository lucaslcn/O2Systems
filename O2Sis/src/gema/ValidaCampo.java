package gema;

/**
 *
 * @author XorNOTE
 */
public class ValidaCampo {

    /**
     *
     * @param campos - recebe um array onde cada indice possui o nome do campo
     * que será verificado.
     * @param valor - recebe o conteudo do campo, onde o indice do valor deve
     * ser o indice do respectivo campo.
     * @param qtd - recebe o valor minimo de caracteres para o campo de indice igual.
     * @return retorna NULL caso todos os campos não sejam vazios, caso algum
     * esteja vazio retorna a lista dos campos que estejam vazios.
     */
    public static String campoVazio(String[] campos, Integer[] qtd, String[] valor) {
        String r = null;
        if (campos.length == valor.length) {
            for (int i = 0; i < campos.length; i++) {
                if (!Gema.vazio(valor[i], qtd[i])) {
                    if (r == null) {
                        r = campos[i].toUpperCase();
                    } else if (campos.length - 1 == i) {
                        r = " e " + campos[i].toUpperCase();
                    } else {
                        r = ", " + campos[i].toUpperCase();
                    }
                }
            }
        } else {
            r = Mensagens.preenchaOsCampos("Programação de campos vazios com erro.");
        }

        return r;
    }
}
